package com.gxa.p2p.common.util;


import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.vo.VerifyCodeVO;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用于存放当前用户的上下文
 *
 * @author novo
 */
public class UserContext {


    public static final String USER_IN_SESSION = "logininfo";


    /**
     * web.xml 中提前配置 RequestContextListener 监听
     *
     * 通过 RequestContextHolder 获取 session
     *
     * @return session
     */
    private static HttpSession getSession() {
        ServletRequestAttributes threadAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = threadAttributes.getRequest();
        HttpSession session = request.getSession();
        return session;
    }

    public static void putLoginInfo(LoginInfo loginInfo) {
        // 得到session,并把current放到session中
        getSession().setAttribute(USER_IN_SESSION, loginInfo);
    }

    public static LoginInfo getLoginInfo() {

        return (LoginInfo) getSession().getAttribute(USER_IN_SESSION);
    }

    public static final String VERIFYCODE_IN_SESSION = "verifyCodeVO_in_session";

    /*
     * 得到session,并把verifyCodeVO存放到session中
     */
    public static void putVerifyCode(VerifyCodeVO verifyCodeVO) {
        getSession().setAttribute(VERIFYCODE_IN_SESSION, verifyCodeVO);
    }

    /*
     * 取出session中的verifyCodeVO
     */
    public static VerifyCodeVO getVerifyCode() {
        VerifyCodeVO verifyCodeVO = (VerifyCodeVO) getSession().getAttribute(VERIFYCODE_IN_SESSION);
        return verifyCodeVO;
    }


}
