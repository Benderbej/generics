package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class GenericStack2<E> implements Stack<E>  {


    E[] entityArr;  //array = new E[0];
    int size;
    private Class<E> entityType = null;


    public GenericStack2(Class<E> entityType) {//передаем тип Е как объект класса Class          увы только такой конструктор сгенерил!!! *
        this.entityType = entityType;
        entityArr = (E[]) Array.newInstance(entityType, 10);
        this.size = 10;
    }

    public GenericStack2(Class<E> entityType, int size) {//передаем тип Е как объект класса Class          увы только такой конструктор сгенерил!!!
        this.entityType = entityType;
        entityArr = (E[]) Array.newInstance(entityType, size);
        this.size = size;
    }

    public GenericStack2(E[] entityArr){//конструктор в обход рефлексии, если уже имеем массив
        this.entityArr = entityArr;
        this.size = Array.getLength(entityArr);
    }

    //GenericStack3<?>[] gens = new GenericStack3<?>[10];




    @Override
    public void push(E element) throws StackException {
        int l = entityArr.length;
        if(l < size) {
            entityArr[l + 1] = element;
        } else {
            throw new StackException();
        }
    }

    @Override
    public E pop() throws StackException {
        if (!isEmpty()){
            //entityArr.length

        } else {
            throw new StackException();
        }

        return null;
    }

    @Override
    public E peek() {

        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize() {
        this.size = entityArr.length;
    }

    @Override
    public boolean isEmpty() {
        if (entityArr.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        int l = entityArr.length;
        if(l < size) {
            return false;
        }
        return true;
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {

        for (E entity: src) {

        }

    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {

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