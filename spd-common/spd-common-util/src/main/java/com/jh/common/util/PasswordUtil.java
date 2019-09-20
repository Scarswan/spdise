package com.jh.common.util;

import org.springframework.util.DigestUtils;

/**
 * 密码工具类
 */
public class PasswordUtil {

    public static String getMD5Password(String pwd){
        return new PasswordUtil().MD5(pwd);
    }

    /**
     * MD5密码加密，32位
     * 该方法是线程安全的
     * @param pwd 用户输入的密码
     * @return
     */
    public synchronized String MD5(String pwd) {
        for (int i = 0; i < 5; i++) {
            pwd = DigestUtils.md5DigestAsHex(pwd.getBytes()).toUpperCase();
        }
        return pwd;
    }

}
