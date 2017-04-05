package com.vther.concurrent.period1.thread;


import java.util.Arrays;

public class _03_ThreadGroup {
    public static void main(String[] args) {

        //  1, 如果构造Thread的时候不传ThreadGroup，Thread会和拉起它的线程的ThreadGroup一样

        Thread t = new Thread("Thread0001") {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        System.out.println(t.getName());

        System.out.println("-------------------------------");
        System.out.println(t.getThreadGroup());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println("-------------------------------");

        System.out.println("t.getThreadGroup().activeCount()-->" + t.getThreadGroup().activeCount());
        System.out.println("-------------------------------");
        Thread[] threads = new Thread[t.getThreadGroup().activeCount()];
        t.getThreadGroup().enumerate(threads);
        Arrays.asList(threads).forEach(thread -> {
            System.out.print(thread);
            System.out.println("--- " + thread.isDaemon());
        });

    }
}
