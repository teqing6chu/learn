package com.demo.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchString {
    public static void f1(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println (m.groupCount ());
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    public static void main(String[] args) {
        String str="aa_bbb_xx_yy_cc";

        String result=str.replaceAll ("aa_bbb_","").replaceAll ("_cc","");
        System.out.println (str.replaceAll ("aa_bbb_([^\\\\]+)_([^\\\\]+)_cc", "$1_$2"));
        System.out.println (result);

    }
}
