package ru.javabit;

import java.util.Collection;

public interface Stack<E> {
    // add new element to the top of the stack
    public void push(E element) throws StackException;
    // return and remove an element from the top
    public E pop() throws StackException;
    // return the top element but doesn’t remove
    public E peek() throws StackException;//добавил сюда исключение так как стек может быть пустым при попытке взять из него последний элемент
    public int getSize();
    public boolean isEmpty();
    public boolean isFull();
    // add all elements from @src to the stack
    public void pushAll(Collection<? extends E> src) throws
            StackException;
    // pop all elements from stack to @dst
    public void popAll(Collection<? super E> dst) throws //просто удаление элементов? без возвращения их?
            StackException;
}
