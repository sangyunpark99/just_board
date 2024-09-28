package com.sangyunpark.smileboard.user.utils;

import java.security.MessageDigest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EncryptUtils {

    public static final String KEY = "SHA256";

    public static String encrypt(String password) {

        String encryptPassword = null;

        MessageDigest md;

        try {
            md = MessageDigest.getInstance(KEY);
            md.update(password.getBytes());
            byte[] data = md.digest();
            StringBuffer sb = new StringBuffer();
            for(byte eachData : data) {
                sb.append(Integer.toString((eachData & 0xff) + 0x100, 16).substring(1)); // 암호화
            }

            encryptPassword = sb.toString();

        } catch(Exception e) {
            log.error("[error] encrypt : {}", e.getMessage());
        }

        return encryptPassword;
    }

}
