package com.demo.base;

public class Test {
    public static void main(String[] args) {
        String  name="abc bb dd";
        Integer age =10;
        replaceSpace(new StringBuffer(name));
    }

    public static String replaceSpace(StringBuffer str){
        String newStr =str.toString().replaceAll(" ","%20");
        System.out.println("================="+newStr);
        return  newStr;
    }
}
