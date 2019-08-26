package com.gxa.p2p.common.service.impl;



import com.gxa.p2p.common.service.IVerifyCodeService;
import com.gxa.p2p.common.util.DateUtil;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import com.gxa.p2p.common.vo.VerifyCodeVO;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
  public class VerifyCodeServiceImpl implements IVerifyCodeService {
    //   模拟发送短信的一些简单值的注入 @value
    @Value("${sms.account}")
    private String account;
    @Value("${sms.password}")
    private String password;
    @Value("${sms.url}")
    private String url;

    @Override
    public void sendVerifyCode(String phoneNumber) {


        // 首先的到session中VerifyCodeVo
        VerifyCodeVO verifyCodeVO = UserContext.getVerifyCode();

        if (null == verifyCodeVO // 表示没有发过验证码
                || (null != verifyCodeVO && DateUtil.getBetweenSecond(verifyCodeVO.getSendTime(), // 如果已经发送了要判断两次发送之间的时间间隔
                new Date()) >= SysConstant.SEND_VERIFYCODE_INTERVAL)) {
            // 生成一个验证码
            int vcode = (int) ((Math.random() * 9 + 1) * 100000); // 五位验证码  只需要随机三位 (321) 另外两位直接赋值(32132)
            //生成完整短信內容
            String content = "您的验证码是：" + vcode + "。请不要把验证码泄露给其他人。";
            // 添加参数
            HashMap<String, String> params = new HashMap<>();
            params.put("account", account);             //查看用户名是登录用户中心->验证码短信->产品总览->APIID
            params.put("password", password);           //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
            System.out.println(phoneNumber);
            params.put("mobile", phoneNumber.trim());  // 发送给哪一个手机号
            params.put("content", content);
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            // 封装请求地址
            try {
                request.setURI(new URI(url));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            // 设置参数
            List<NameValuePair> nameValuePairsList = new ArrayList<>();
            // 封装数据值
            for (String name : params.keySet()) {
                String value = params.get(name);
                nameValuePairsList.add(new BasicNameValuePair(name, value));  // gun
            }
            HttpClient client = new DefaultHttpClient();

            try {
                request.setEntity(new UrlEncodedFormEntity(nameValuePairsList, HTTP.UTF_8));
                HttpResponse response = client.execute(request);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {    //请求成功
                    BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity()
                            .getContent(), "utf-8"));
                    StringBuilder sb = new StringBuilder("");
                    String line = "";
                    String NL = System.getProperty("line.separator");   // apache建议回车使用line.separator(回车)     \n
                    while ((line = in.readLine()) != null) {
                        sb.append(line).append(NL);    // 每添加一个值，追加一个回车
                    }
                    in.close();
                    String SubmitResult = sb.toString();
                    System.out.println("服务器返回结果内容：" + SubmitResult);
                    // 解析XML文件   Document XML文件对象
                    Document doc = DocumentHelper.parseText(SubmitResult);
                    Element root = doc.getRootElement();
            /*
               <code>回执状态码</code>
               <msg>回执消息</msg>
               <smsid>回执ID</smsid>
             */
                    String code = root.elementText("code");
                    String msg = root.elementText("msg");
                    String smsid = root.elementText("smsid");

                    System.out.println("回执状态码：" + code);
                    System.out.println("回执消息：" + msg);
                    System.out.println("回执ID：" + smsid);

                    //状态码为2表示发送成
                    if ("2".equals(code)) {
                        System.out.println("短信提交成功");
                        //把手机号、验证码、当前时间传入VerifyCodeVO
                        verifyCodeVO = new VerifyCodeVO(phoneNumber, String.valueOf(vcode), new Date());
                        // 把VC放入session中
                        UserContext.putVerifyCode(verifyCodeVO);
                    } else {
                        throw new RuntimeException("服务器繁忙，请稍后再试");
                    }
                }
            } catch (IOException | DocumentException e) {
                throw new RuntimeException("发送短信失败");
            } finally {
                // Release connection
                request.releaseConnection();
                client.getConnectionManager().shutdown();
            }

            // 构建一个vo对象 将vo放入session中
            verifyCodeVO = new VerifyCodeVO(phoneNumber, String.valueOf(vcode), new Date());
            UserContext.putVerifyCode(verifyCodeVO);
        } else {
            throw new RuntimeException("发送过于频繁");
        }
    }

    /**
     * 做关于手机验证码的校验 (需要校验是否发送验证码之前的手机号的验证码 : 没有过期)
     */
    @Override
    public boolean validate(String phoneNumber, String verifyCode) {
        // 从session中取出vo对象
        VerifyCodeVO verifyCodeVO = UserContext.getVerifyCode();
        return null != verifyCodeVO // 表示发了验证码
                && verifyCodeVO.getPhoneNumber().equals(phoneNumber) // 前后两次验证的手机号码相同
                && verifyCodeVO.getVerifyCode().equalsIgnoreCase(verifyCode) // 两次验证码相同(不区分大小写)
                && DateUtil.getBetweenSecond(verifyCodeVO.getSendTime(), new Date()) <= SysConstant.VERIFYCODE_VALID_TIME; // 表示短信在有效期内

    }

}
