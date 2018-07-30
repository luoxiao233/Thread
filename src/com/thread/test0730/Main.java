package com.thread.test0730;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(Subclass.value);
    }

}

class SuperClass {
    static {
        System.out.println("父类初始化");
    }
//    public static int value= 123;
}

class Subclass extends SuperClass{

    static {
        System.out.println("子类初始化");
    }
    public static int value = 456;
}
