package com.vther.concurrent.period1.thread;


public class _02_ConstructorsOfThread {
    public static void main(String[] args) {
        //  0, Thread的源码使用了模板模式和策略模式
        //  1, 创建线程对象Thread，默认有一个线程名，以Thread-开头，从0开始计数
        //  2, 如果在构造Thread的时候没有传递Runnable或者没有复写Thread的run方法，则不会执行任何方法
        //  3, Thread名字可以重复
        //  4, 如果构造Thread的时候不传ThreadGroup，Thread会和拉起它的线程的ThreadGroup一样

        Thread t1 = new Thread("Thread0001");
        Thread t2 = new Thread("Thread0001");
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }
}
