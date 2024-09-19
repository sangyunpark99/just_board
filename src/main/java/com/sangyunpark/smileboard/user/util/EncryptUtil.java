package com.sangyunpark.smileboard.user.util;

import java.security.MessageDigest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EncryptUtil {
    public static final String KEY = "SHA-256";

    public static String encoder(String password) {

        String shaPassword = null;
        MessageDigest sh;
        try {
            sh = MessageDigest.getInstance(KEY);
            sh.update(password.getBytes());
            byte[] data = sh.digest();
            StringBuffer sb = new StringBuffer();

            for(byte byteData: data) {
                sb.append(Integer.toString((byteData & 0xff) + 0x100, 16).substring(1));
            }

            shaPassword = sb.toString();

        }catch (Exception e) {
            log.error("encoder SHA256 ERROR : {}", e.getMessage());
        }

        return shaPassword;
    }
}
