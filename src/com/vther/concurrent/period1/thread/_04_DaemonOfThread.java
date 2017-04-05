package com.vther.concurrent.period1.thread;


public class _04_DaemonOfThread {
    public static void main(String[] args) {

        //  1, 守护线程设为false意味着：拉起该线程的线程会等待该线程执行完毕
        //             设为true意味着：拉起该线程的线程结束时，该线程也会随之结束
        //  2, t.setDaemon要在start方法前调用，否则会抛出IllegalThreadStateException

        Thread t = new Thread("Thread0001") {
            @Override
            public void run() {
                try {
                    System.out.println("Thread run");
                    Thread.sleep(10000L);
                    System.out.println("Thread done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(false);
        t.start();

        System.out.println(t.getName());

    }
}
