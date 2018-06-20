package com.demo.base;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        double d1=0.0012;
        double d2=0.0013;
        BigDecimal b1= BigDecimal.valueOf(d1);
        BigDecimal b2= BigDecimal.valueOf(d2);
        double d3=d1+d2;
        double d4=d1*d2;
        BigDecimal b3 =b1.add(b2);
        BigDecimal b4 =b1.multiply(b2);
        System.out.println("d3:"+d3+",d4:"+d4);
        System.out.println("b3:"+b3+",b4:"+b4);
    }
}
