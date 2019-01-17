package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericStack<E> implements Stack<E>  {

    List<E> container;
    int capacity;//вместимость стека
    int size;//количество элементов по факту


    GenericStack(){
        container = new ArrayList<>(10);

        size = 10;
    }

    GenericStack(int capacity){
        container = new ArrayList<>(capacity);
        this.capacity = capacity;
    }


    @Override
    public void push(E element) throws StackException {
        int s = container.size();
        if(s < capacity) {
            container.add(element);
        } else {
            throw new StackException();
        }
    }

    @Override
    public E pop() throws StackException {
        int s = container.size();
        E element;
        if(s > 0) {
            element = container.get(container.size());
            container.remove(container.size());
        } else {
            throw new StackException();
        }
        return element;
    }

    @Override
    public E peek() throws StackException {
        int s = container.size();
        E element;
        if(s > 0) {
            element = container.get(container.size());
        } else {
            throw new StackException();
        }
        return element;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(container.isEmpty()){return true;}
        return false;
    }

    @Override
    public boolean isFull() {
        if(container.size() == capacity){return true;}
        return false;
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {
        if(src.size() > capacity) {
            for (E entity : src) {

            }
        } else {
            throw  new StackException();
        }
    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {

    }








}
