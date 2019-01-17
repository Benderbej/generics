package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class GenericStack3<E> implements Stack<E>  {

    FixedCapacityArrayList<E> container;
    int capacity;//вместимость стека
    int size;//количество элементов по факту


    GenericStack3(){
        container = new FixedCapacityArrayList<E>(10);
        size = 10;
    }

    GenericStack3(int capacity){
        container = new FixedCapacityArrayList<E>(capacity);
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




    private class FixedCapacityArrayList<E> extends ArrayList<E> {
        public FixedCapacityArrayList(int i) {
            super(i);
        }


//        не переопределить - приватно -пакетно недоступно, никак не вырезать повышение capacity


//        public void ensureCapacity(int minCapacity) {
//            int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
//                    // any size if not default element table
//                    ? 0
//                    // larger than default for default empty table. It's already
//                    // supposed to be at default size.
//                    : DEFAULT_CAPACITY;
//
//            if (minCapacity > minExpand) {
//                ensureExplicitCapacity(minCapacity);
//            }
//        }

//        private void ensureCapacityInternal(int minCapacity) {
//            System.err.println("internal capacity is not ensured!");
//        }
//
//        private void ensureExplicitCapacity(int minCapacity) {
//            System.err.println("explicit capacity is not ensured!");
//        }

    }





}
