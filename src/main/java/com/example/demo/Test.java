package com.example.demo;

import org.springframework.util.StringUtils;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        boolean flag = true;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
       /* if (flag) {
            list.forEach(i ->{
                if (i % 2 != 0) {
                    list.remove(i);
                }
            });
        }*/
        System.out.println(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            int val = list.get(i);
            if (val % 2 != 0)
                list.remove(i);
        }

        System.out.println(list);

        /*Map<String, Object> map = new LinkedHashMap<>();

        map.put("1",null);
        map.put("2","2");
        map.put(null,"null123");
        map.put("4","");

        *//*map.forEach((k,v) -> {
            if (StringUtils.isEmpty((String) v)) {
                map.remove(k,v);
            }
        });*//*

        Iterator<Map.Entry<String, Object>> iterator =
                map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            if (StringUtils.isEmpty(next.getValue())) {
                iterator.remove();
            }
        }

        map.forEach((k,v) -> {
            System.out.println(k + " : " + v);
        });*/

    }

}
