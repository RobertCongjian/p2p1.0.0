package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Mailverify;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.MailverifyMapper;
import com.gxa.p2p.common.mapper.SystemdictionaryitemMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.service.IVerifyCodeService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.DateUtil;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;


    @Autowired
    private IVerifyCodeService iVerifyCodeService;

    @Autowired
    private MailverifyMapper mailverifyMapper;


    @Override
    public Map<String,Object> getInfo(HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("logininfo");
        map.put("userinfo",userinfoMapper.getUserInfoAndSystemdictionaryById(loginInfo.getId()));
        map.put("systemdictionaryitem",systemdictionaryitemMapper.selectAll());
        return map;

    }


    @Override
    public List<Systemdictionaryitem> selectItemBysn(String sn) {
        return systemdictionaryitemMapper.selectItemBysn(sn);
    }

    @Override
    public Userinfo getUserInfoById(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItem(Userinfo userinfo,Long id) {


        // 设置状态码
        if ( !userinfo.getIsBasicInfo()) {
            userinfo.addState(BitStatesUtils.OP_USER_INFO);
        }

        int row = userinfoMapper.updateItem(userinfo,id);

        if(row!=1){
            throw new RuntimeException("更新失败！");
        }
    }

    @Override
    public void bindPhone(String phoneNumber, String verifyCode) {
        // 先做验证码的校验 (一般关于验证码的都交给验证码相关服务)
        if (iVerifyCodeService.validate(phoneNumber,verifyCode)) {
            //如果校验成功,给当前用户绑定手机号和状态码
            Userinfo userInfo = userinfoMapper.selectByPrimaryKey(UserContext.getLoginInfo().getId());
            //先判断当前用户是否已经绑定了手机
            if ( !userInfo.getIsBindPhone()) { //表示当前没有绑定手机
                //给当前用户添加状态码和手机号
                userInfo.setPhonenumber(phoneNumber);
                userInfo.addState(BitStatesUtils.OP_BIND_PHONE);
                userinfoMapper.updateItem(userInfo,UserContext.getLoginInfo().getId());
            }
        }else{
            throw new RuntimeException("绑定失败");
        }
    }


    /**
     * 绑定邮箱的实现
     */
    public void bindEmail(String uuid) {
        //根据uuid查村mailVerify对象
        Mailverify mailVerify = mailverifyMapper.selectByUUID(uuid);
        if (null != mailVerify
                && DateUtil.getBetweenSecond(mailVerify.getSendtime(), new Date()) < SysConstant.EMAIL_VALID_DAY * 24 * 3600 ) {
            //如果有 且在有效期内 的用户没有绑定邮箱
            Userinfo userInfo = userinfoMapper.selectByPrimaryKey(mailVerify.getLogininfoId());
            if ( !userInfo.getIsBindEmail()) {
                //添加邮箱状态码  设置email属性
                userInfo.addState(BitStatesUtils.OP_BIND_EMAIL);
                userInfo.setEmail(mailVerify.getEmail());
                userinfoMapper.updateItem(userInfo,mailVerify.getLogininfoId());
            }
        }else{
            throw new RuntimeException("验证邮箱地址错误!");
        }
    }


}
