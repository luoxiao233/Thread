package com.thread.test0803;

import java.util.concurrent.atomic.AtomicInteger;

//atomic类型就是一个原子操作可用的类型，他可以在没有锁的情况下做到线程安全
public class AddCountThreadTest extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }


    public static void main(String[] args) {
        AddCountThreadTest countService = new AddCountThreadTest();
        Thread t1 = new Thread(countService);
        t1.start();
        Thread t2 = new Thread(countService);
        t2.start();
        Thread t3 = new Thread(countService);
        t3.start();
        Thread t4 = new Thread(countService);
        t4.start();
        Thread t5 = new Thread(countService);
        t5.start();
    }
}
