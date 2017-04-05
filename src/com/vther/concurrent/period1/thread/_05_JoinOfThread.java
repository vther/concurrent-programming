package com.vther.concurrent.period1.thread;


public class _05_JoinOfThread {
    public static void main(String[] args) {

        //  1, t.join()：拉起线程t的线程main会等待线程t执行完毕才开始执行
        //  2, t.join()必须设置在t.start()后才有效

        System.out.println("Main Thread start");

        Thread t = new Thread("Thread") {
            @Override
            public void run() {
                try {
                    System.out.println("Thread run");
                    Thread.sleep(5000L);
                    System.out.println("Thread done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(false);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread done");

    }
}
