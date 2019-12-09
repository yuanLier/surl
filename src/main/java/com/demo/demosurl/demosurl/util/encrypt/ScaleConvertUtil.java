package com.demo.demosurl.demosurl.util.encrypt;

import java.util.Stack;

/**
 * @author yuanyiwen
 * @create 2019-12-07 22:00
 * @description 进制转换工具类
 */
public abstract class ScaleConvertUtil {

    /**
     * 将10进制数字转换为62进制
     * @param number 数字
     * @param length 转换成的62进制长度，不足length长度的高位补0
     * @return
     */
    public static String convert(long number, int length){

        char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

        Long rest=number;
        Stack<Character> stack=new Stack<Character>();
        StringBuilder result=new StringBuilder(0);
        while(rest!=0){
            stack.add(charSet[new Long((rest-(rest/62)*62)).intValue()]);
            rest=rest/62;
        }
        for(;!stack.isEmpty();){
            result.append(stack.pop());
        }
        int result_length = result.length();
        StringBuilder temp0 = new StringBuilder();
        for(int i = 0; i < length - result_length; i++){
            temp0.append('0');
        }

        return temp0.toString() + result.toString();
    }
}
