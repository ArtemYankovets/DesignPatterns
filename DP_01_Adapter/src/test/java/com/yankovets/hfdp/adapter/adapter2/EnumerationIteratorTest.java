package com.yankovets.hfdp.adapter.adapter2;

import java.util.*;
import java.util.Iterator;

public class EnumerationIteratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("Allan");
        list.add("Bob");
        list.add("Steve");
        list.add("Mark");

        Iterator<String> iterator = list.iterator();

        Enumaration enumaration = new IteratorToEnumeration(iterator);

        while (enumaration.hasMoreElements()){
            System.out.println(enumaration.nextElement() + " ");
        }

    }
}
