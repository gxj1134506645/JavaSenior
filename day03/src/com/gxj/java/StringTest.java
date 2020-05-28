package com.gxj.java;

/**
 * @author 葛孝杰
 * @date 2020/5/28 - 17:10
 */
public class StringTest {
    public static void main(String[] args) {
        String string = "ass.dfg.ghj";
        String[] strs = string.split("\\.");
        for (String str : strs) {
            System.err.println(str);
        }
    }
}
