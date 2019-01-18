package ru.javabit;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        GenericStack<Integer> genericStack = new GenericStack<Integer>(Integer.class);
        try {
            genericStack.push(6);
            genericStack.push(8);
            genericStack.push(6);
            genericStack.push(8);
            genericStack.push(6);

            genericStack.push(8);
            genericStack.push(6);
            genericStack.push(8);
            genericStack.push(6);
            genericStack.push(8);

            ArrayList<Integer> arl= new ArrayList<>();

            genericStack.popAll(arl);
            arl.size();
            System.out.println("arl.size()" + arl.size());



            ArrayList<Integer> arl2 = new ArrayList<>();
            arl2.add(25);
            arl2.add(2423);

            genericStack.pushAll(arl2);
            System.out.println("arl2.size()"+arl2.size());


            //genericStack.push(8);
        } catch (StackException e) {
            e.printStackTrace();
        }
        System.out.println(genericStack.toString());



    }
}
