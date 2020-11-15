package com.lisg.user.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-15 10:37
 **/
@Slf4j
public class PasswordUtil {

    public static String encryptMd5String(String str){
        String md5 = "";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < byteData.length ; i++){
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            md5 = sb.toString();
        }catch(NoSuchAlgorithmException e){
            md5 = null;
        }
        return md5;
    }

    public static String encryptSha512String(String str){
        MessageDigest md;
        String sha512 = "";

        try {
            md = MessageDigest.getInstance("SHA-512");

            md.update(str.getBytes());
            byte[] mb = md.digest();
            for (int i = 0; i < mb.length; i++) {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                sha512 += s;
            }
        } catch (NoSuchAlgorithmException e) {
            log.warn("encryptSha512String method",e);
            return null;
        }
        return sha512;
    }

}
