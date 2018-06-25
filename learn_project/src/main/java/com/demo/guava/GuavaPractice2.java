package com.demo.guava;

import com.google.common.base.Function;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GuavaPractice2 {

    public static void main(String[] args) {
        //testListToUniqueMap ();
      //  testListToMap ();
        testList();
    }

    /**
     * Guava list转 map 转化后具有唯一Key
     * key重复报错
     */
    public static void testListToUniqueMap(){
        List<Person> list = Lists.newArrayList ();
        list.add (new Person ("xiaoli",22));
        list.add (new Person ("lisi",23));
        list.add (new Person ("wangliu",29));

        Map<String,Person> map = Maps.uniqueIndex (list, new Function<Person, String> () {
            @Override
            public String apply(Person person) {
                return person.getName ()+"_key";
            }
        });
        Iterator<String> iterator = map.keySet ().iterator ();
        while (iterator.hasNext ()){
            String key=iterator.next ();
            Person person =map.get (key);
            System.out.println (key+"---"+person.getName ()+"--"+person.getAge ());
        }
    }

    public static void testListToMap(){
        List<Person> list = Lists.newArrayList ();
        list.add (new Person ("xiaoli",22));
        list.add (new Person ("lisi",23));
        list.add (new Person ("wangliu",29));

        /**
         * 转换后的Map有重复键
         */
        Multimap<String, Person> multiMap = Multimaps.index(list, new Function<Person, String>() {
            public String apply(Person person) {
                return person.getName();
            }
        });

        Iterator<String> iterator = multiMap.keySet ().iterator ();
        while (iterator.hasNext ()){
            String key=iterator.next ();
           // Person person = (Person) multiMap.get (key);
            System.out.println (key);
            Collection<Person> people = multiMap.get (key);

        }
    }

    /**
     * list中提取一个新的list
     * 一般用于提取一个ids
     */
    public static void testList(){
        List<Person> list = Lists.newArrayList ();
        list.add (new Person ("xiaoli",22));
        list.add (new Person ("lisi",23));
        list.add (new Person ("wangliu",29));
        //封装
        List<String> resultList = Lists.transform(list, new Function<Person, String >() {
            @Override
            public String apply(Person goodsTagRelation) {
                return goodsTagRelation.getName ();
            }
        });
        for (String name : resultList) {
            System.out.println (name);
        }
    }

}
