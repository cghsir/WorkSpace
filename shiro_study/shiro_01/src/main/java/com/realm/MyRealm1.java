package com.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * 自定义realm实现
 * Created by cghsir on 2017/7/11.
 */
public class MyRealm1 implements Realm{

    public String getName() {
        return "myrealm1";
    }

    // token是否是用户名密码token
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }


    /**
     * 登陆验证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//得到用户名
        String password = new String((char[]) token.getCredentials());//得到密码
        if (!"zhang".equals(username)) {
            throw new UnknownAccountException();//用户名错误
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();//如果密码错误
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
