package com.nswdwy.java;

import org.omg.PortableInterceptor.IORInterceptor_3_0;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author yycstart
 * @create 2020-08-27 16:45
 */
public class Test01 {
    public static void main(String[] args) {
        String str = "vdvdzfdzhshdsgds撒旦发射点2131";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer count = map.get(ch);
            if(count == null){
                count = 0;
            }
            map.put(ch,++count);
        }
        System.out.println(map);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < map.size(); i++) {
            list.add(map.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list);
        }

    }
}
