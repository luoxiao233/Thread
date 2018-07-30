package com.thread.test0730;

public class run {
    public static void main(String[] args) {
        try {
            MyThread1 thread1 = new MyThread1();
            thread1.start();
            thread1.sleep(200);
            thread1.interrupt();
            System.out.println("看看什么时候输出");
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止！进入catch"+ this.isInterrupted());
            e.printStackTrace();
        }
    }
}

