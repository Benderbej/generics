package ru.javabit;

import java.lang.reflect.Array;
import java.util.Collection;

public class GenericStack<E> implements Stack<E>  {

    private E[] entityArr;
    private int capacity; //length of entityArr
    private Class<E> entityType = null;
    private int size; //amount of non-null elements in stack


    public static void main(String[] args) {
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

            //genericStack.push(8);
        } catch (StackException e) {
            e.printStackTrace();
        }
        System.out.println(genericStack.toString());
    }

    public GenericStack(Class<E> entityType) {//передаем тип Е как объект класса Class          увы только такой конструктор сгенерил!!! *
        this.entityType = entityType;
        entityArr = (E[]) Array.newInstance(entityType, 10);
        this.capacity = 10;
    }

    public GenericStack(Class<E> entityType, int size) {//передаем тип Е как объект класса Class          увы только такой конструктор сгенерил!!!
        this.entityType = entityType;
        entityArr = (E[]) Array.newInstance(entityType, size);
        this.capacity = size;
    }

    public GenericStack(E[] entityArr){//конструктор в обход рефлексии, если уже имеем массив
        this.entityArr = entityArr;
        this.capacity = Array.getLength(entityArr);
    }

    //GenericStack3<?>[] gens = new GenericStack3<?>[10];

    @Override
    public void push(E element) throws StackException {
        System.out.println("capacity="+capacity);
        System.out.println("s="+getSize());
        if(getSize() < capacity) {
            entityArr[getSize()] = element;
        } else {
            throw new StackException();
        }
    }

    @Override
    public E pop() throws StackException {
        E entity;
        if (!isEmpty()){
            //entityArr.length
            entity = entityArr[getSize()-1];
            entityArr[getSize()-1] = null;
        } else {
            throw new StackException();
        }
        return entity;
    }

    @Override
    public E peek() throws StackException {
        E entity;
        if (!isEmpty()){
            //entityArr.length
            entity = entityArr[getSize()];
            entityArr[getSize()] = null;
        } else {
            throw new StackException();
        }
        return entity;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (E entity: entityArr) {
            if(entity != null) {//с примитивами также четко будет работать? int[] char[] - вопрос не стоит так как обобщаемый тип - не может быть примитивом - мы не можем написать GenericStack<int>
                size++;
                System.out.println("entity.toString()"+entity.toString());
            }
        }
        System.out.println("GenericStack.size is="+size);
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E entity: entityArr) {
            if(entity != null) {
                sb.append(entity.toString());
            } else {
                sb.append("null");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        if (getSize() == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        int l = entityArr.length;
        if(getSize() < capacity) {
            return false;
        }
        return true;
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {//<? extends E> defines E as the upper bound: "This can be cast to E".
        if(src.size() > capacity){
            throw new StackException();
        } else {
            for (E element: src) {
                entityArr[getSize()] = element;
            }
        }
    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {//<? super E> defines E as the lower bound: "E can be cast to this."
        if (getSize()>0) {
            while (getSize() > 0) {
                dst.add(this.pop());
            }
        } else {
            throw new StackException();
        }
    }

    public Class<E> getEntityType() {
        return this.entityType;
    }

}
/*
Реализуйте класс StackException extends Exception – исключение должно выбрасываться,
если стек полон и кто-то вызывает метод push()
или если стек пуст и вызывается метод pop().




по проблеме по созданию экземпляров неизвестного типа

смотрел как бы можно сделать финт ушами чтобы создать объект или массив с неизвестным типом, ничего не получилось - везде решения либо со сторониими библиотеками
либо с использованием рефлексии, либо какие-то другие небезопасные, неуклюжие или требующие каких-то нестандартных ресурсов пути



комментарий к просмотренным источникам:
ввиду отсутствия опыта я не стал городить ничего из того в чем я не уверен и решил пойти по некрасивому но ясному пути -
просто предоставить бремя определения типа на пользователя класса(может это и не есть хороший подход, но по крайней мере он ясный
и стриает возможные противоречия)

просмотренные источники:
ограничения на обобщения хорошо описаны у Шилдта

о wildcard
http://bighow.org/questions/26146371/how-to-instantiate-generics-using-wild-card-

oracle
https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createObjects

https://habr.com/ru/post/66593/

как создавать экземпляры неизвестных типов в генериках(узнавать тип изнутри класса)
http://qaru.site/questions/15716/get-generic-type-of-class-at-runtime

хорошее объяснение про стирание
https://ru.stackoverflow.com/questions/585509/%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D1%8D%D0%BA%D0%B7%D0%B5%D0%BC%D0%BF%D0%BB%D1%8F%D1%80%D0%B0-generic-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0-%D1%81-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-%D1%80%D0%B5%D1%84%D0%BB%D0%B5%D0%BA%D1%81%D0%B8%D0%B8













 */