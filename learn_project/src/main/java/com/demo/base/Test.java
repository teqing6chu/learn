package com.demo.base;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String  name="abc bb dd";
        Integer age =10;
        String str= String.format("name:%s,age:%d", name, age);
        List<String> list = new ArrayList<> ();
        list.add ("a");
        list.add ("b");
        list.add ("c");
        for (String s : list) {
            System.out.println ("==="+s);
        }
        replaceSpace(new StringBuffer(name));
        System.out.println (getSymbol ("btcada"));
    }

    public static String replaceSpace(StringBuffer str){
        String newStr =str.toString().replaceAll(" ","%20");
        System.out.println("================="+newStr);
        return  newStr;
    }

    public static String getSymbol(String originalSymbol){
        List<String> symbolList = mockList ();
        String targetSymbol=null;
        if (symbolList != null) {
            for (String symbol : symbolList) {
                if (symbol.replaceAll ("_","").equals (originalSymbol)){
                    targetSymbol= symbol;
                    break;
                }
            }
        }
        return targetSymbol;
    }

    public static  List<String> mockList(){
        List<String> list = Lists.newArrayList ();
        list.add ("btc_usdt");
        list.add ("btc_ada");
        return list;
    }
}
