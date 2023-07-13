package com.test.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: roy
 * @date: 2023/7/13 9:48
 * @description: MD5 加密算法 ,不如现在的JWT广泛,但是可以使用
 */

public class MD5Util {
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    /*进行数据哈希处理*/
    private  static  String byteArrayToHexString(byte [] b){
        StringBuffer resultSb=new StringBuffer();
        for(int i=0;i<b.length;i++){
        resultSb.append( byteToHexString(b[i]));}
        return  resultSb.toString();
    }
    /*对byte 数据进行哈希处理 ,如果byte 转换为int 数据
    * 小于0 加256
    * 数据取16的倍数, 取16的模 进行哈希代换
    * */
    private  static  String byteToHexString(byte b){
        int n=b;
        if(n<0){
            n += 256;
        }
        int d1=n/16;
        int d2=n%16;
        return  hexDigits[d1]+hexDigits[d2];
    }
    public  static  String MD5Encode(String origin,String charsetname)  {
        String resultString=null;
        try {
            resultString=new String(origin);
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            if(charsetname==null||"".equals(charsetname)){
                resultString =byteArrayToHexString(messageDigest.digest(resultString.getBytes()));

            }else {
                try {
                    resultString = byteArrayToHexString(messageDigest.digest(resultString.getBytes(charsetname)));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  resultString;
    }

    public static void main(String[] args) {
        MD5Util md5Util=new MD5Util();
        String s=MD5Encode("123","UTF-8");
        System.out.println(s);
    }
}
    

