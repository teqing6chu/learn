package com.demo.gavua;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Guava Optional类相关方法
 */
public class GavuaPractice1 {
    /**
     *  1.Optional.of(T)：获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错。
     *  2.abstract boolean isPresent()  含一个(非空)的实例返回true。
     *  3.static <T> Optional<T> fromNullable(T nullableReference) 如果nullableReference非空，返回一个包含引用Optional实例;否则返回absent()
     */

    public static void  test1(){
        Integer a=10;
        Optional<Integer> optional = Optional.of(a);
        Optional t=Optional.fromNullable(a);
        System.out.println(optional.isPresent());//true
//    System.out.println("返回所包含的实例，它必须存在参数a不能为空。"+t.get());//10

        Integer b=null;
        Optional<Integer> optional_1 = Optional.fromNullable(b);
        //stem.out.println("isPresent当值为空时返回false："+optional_1.isPresent());//false

        BigDecimal c =null;
        BigDecimal bigDecimal =Optional.fromNullable(c).or(BigDecimal.ONE);
        System.out.println("or 如果值存在则返回当前值，不存在则返回默认值："+bigDecimal);//1

        String str =null;
        str =Optional.fromNullable(str).orNull();
        System.out.println("orNull 如果值存在则返回当前值，不存在则返回null:"+str);//null
    }

    /**
     * abstract <V> Optional<V> transform(Function<? super T,V> function)
     *  如果实例存在，则它被转换给定的功能;否则absent()被返回。
     */
    public static void test2(){
        Map<String,Integer> map = Maps.newHashMap();
        map.put("a",100);
        Optional<Map<String,Integer>> optional = Optional.fromNullable(map);
        Optional<Boolean> optional11 = optional.transform(new Function<Map<String, Integer>, Boolean>() {
            @Override
            public Boolean apply(Map<String, Integer> stringIntegerMap) {
                return stringIntegerMap.get("a")==100;
            }
        });
        System.out.println("================"+optional11.get());
    }
    public static void main(String[] args) {
        test1();
        test2();
        System.out.println(1 << 3);
        int option=0;
        int OPTION_CITY=1;
        System.out.println(  option |= OPTION_CITY);

    }
}

