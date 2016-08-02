/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.utils;

import java.text.DateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-26 10:32:55
 * @copyright ©2016 马面 All Rights Reserved
 */
public class SecurityUtils {

    private static final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.SHORT);

    /**
     * 获取盐值
     * Base64(now + identity)若identity为null则随机生成一个字符串代替
     *
     * @param identity can be null
     * @return
     */
    public static String getSalt(String identity) {
        String now = df.format(new Date());
        String identityString = StringUtils.isBlank(identity)
                                ? RandomStringUtils.randomAlphanumeric(20)
                                : identity.trim();
        return Base64.encodeBase64String(blend(now, identityString));
    }

    /**
     * 密码密文
     *
     * @param salt
     * @param userPassword
     * @return
     */
    public static String getPassphrase(String salt, String userPassword) {
        return DigestUtils.shaHex(blend(salt, userPassword));
    }

    /**
     * 混合两个字节数组
     */
    private static byte[] blend(String a, String b) {
        return a.concat(b).getBytes();
    }
    
}
