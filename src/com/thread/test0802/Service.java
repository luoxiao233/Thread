package com.thread.test0802;


//只要锁中的对象引用不变，即使对象的属性被改变，运行的结果还是同步的
public class Service {
    public void serviceMethod(Userinfo userinfo) {
        synchronized (userinfo) {
            try {
                System.out.println(Thread.currentThread().getName());
                userinfo.setUsername("abcabcabc");
                Thread.sleep(3000);
                System.out.println("end! time=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Userinfo userinfo = new Userinfo();
        ThreadA1 a1 = new ThreadA1(service,userinfo);
        a1.setName("a1");
        a1.start();
        Thread.sleep(50);
        ThreadB1 b1 = new ThreadB1(service,userinfo);
        b1.setName("b1");
        b1.start();
    }







}

class Userinfo {
    String username;
    String password;

    public Userinfo() {
    }

    public Userinfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class ThreadA1 extends Thread {
    private Service service;
    private Userinfo userinfo;
    public ThreadA1 (Service service,Userinfo userinfo){
        super();
        this.service = service;
        this.userinfo = userinfo;
    }

    @Override
    public void run() {
        service.serviceMethod(userinfo);
    }
}
class ThreadB1 extends Thread {
    private Service service;
    private Userinfo userinfo;
    public ThreadB1 (Service service,Userinfo userinfo){
        super();
        this.service = service;
        this.userinfo = userinfo;
    }

    @Override
    public void run() {
        service.serviceMethod(userinfo);
    }
}