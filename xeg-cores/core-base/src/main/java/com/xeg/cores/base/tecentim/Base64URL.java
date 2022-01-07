package com.xeg.cores.base.tecentim;

import java.util.Base64;

/****
 * @Description
 * @Author CaoYunXiang
 * @Data create in 2021/5/12 9:47
 * @Version 1.0
 **/
public class Base64URL {
    public static byte[] base64EncodeUrl(byte[] input) {
        byte[] base64 = Base64.getEncoder().encode(input);
        for (int i = 0; i < base64.length; ++i) {
            switch (base64[i]) {
                case '+':
                    base64[i] = '*';
                    break;
                case '/':
                    base64[i] = '-';
                    break;
                case '=':
                    base64[i] = '_';
                    break;
                default:
                    break;
            }
        }
        return base64;
    }
}
