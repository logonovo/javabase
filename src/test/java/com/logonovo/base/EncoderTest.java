package com.logonovo.base;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2017/10/15 21:54
 */
public class EncoderTest {

    @Test
    public void encodeTest(){
        String name ="I am 君山";
        toHex(name.getBytes());

        try {
            byte[] iso8859 = name.getBytes("iso-8859-1");
            toHex(iso8859);
            byte[] gb2312 = name.getBytes("gb2312");
            toHex(gb2312);
            byte[] gbk = name.getBytes("gbk");
            toHex(gbk);
            byte[] utf8 = name.getBytes("utf-8");
            toHex(utf8);
            byte[] utf16 = name.getBytes("utf-16");
            toHex(utf16);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void toHex(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase());
            System.out.print(" ");
        }
        System.out.println();
    }
}
