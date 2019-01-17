package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Type t = String.class;
        //GenericStack3<String> gen = new GenericStack3<String>(Class<String>);

        //GenericStack2<Integer>[] gen = new GenericStack2<Integer>(new Class<Integer>());

        //new Class<Integer>();

        //new Class<Integer>();

        Class<GenericStack2> manager = GenericStack2.class;

        Integer i = new Integer(7);








        int[] arr = new int[20];
        arr[0]=5;
        arr[1]=6;
        System.out.println(arr.length + " " + Array.getLength(arr));


        ArrayList<Integer> a = new ArrayList<>(7);
        a.add(6);
        a.add(12);
        System.out.println(a.size());
        a.add(6);
        a.add(12);
        a.add(6);
        a.add(12);
        a.add(6);
        a.add(12);
        a.add(6);
        a.add(12);
        a.add(6);
        a.add(12);

    }
}
