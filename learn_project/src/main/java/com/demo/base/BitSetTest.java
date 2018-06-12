package com.demo.base;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BitSetTest {
    public static void main(String[] args) {
        test(8,12,22);
    }

    public static void test(Integer userId,Integer adminId,Integer companyId){
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setAdminId(12);
        user1.setCompanyId(22);
        user1.setUserId(8);

        User user2= new User();
        user2.setAdminId(11);
        user2.setCompanyId(33);
        user2.setUserId(7);

        User user3 = new User();
        user3.setAdminId(12);
        user3.setCompanyId(22);
        user3.setUserId(8);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        BitSet userIdBit = new BitSet();
        BitSet adminIdBit = new BitSet();
        BitSet companyIdBit = new BitSet();
        for (User user : list) {
            userIdBit.set(user.getUserId());
            adminIdBit.set(user.getAdminId());
            companyIdBit.set(user.getCompanyId());
        }
        if (userIdBit.get(userId) && adminIdBit.get(adminId) && companyIdBit.get(companyId)){
            System.out.println("数据存在=========");
        }else{
            System.out.println("不存在==============");
        }
    }
}
