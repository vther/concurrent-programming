package com.vther.concurrent.period1.thread;


public class _06_InterruptOfThread {
    public static void main(String[] args) {

        //  1, t.join()：拉起线程t的线程main会等待线程t执行完毕才开始执行
        //  2, t.join()必须设置在t.start()后才有效

        System.out.println("Main Thread start");

        Thread t = new Thread("Thread") {
            @Override
            public void run() {
                while (true) {

                }

            }
        };
        t.setDaemon(false);
        t.start();
        System.out.println("before t.interrupt()");
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println("after t.interrupt()");
        System.out.println(t.isInterrupted());

        System.out.println("Main Thread done");

    }

    public static void main2(String[] args) {


        System.out.println("Main Thread start");

        Thread t = new Thread("Thread") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t.setDaemon(false);
        t.start();
        System.out.println("before t.interrupt()");
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println("after t.interrupt()");
        System.out.println(t.isInterrupted());

        System.out.println("Main Thread done");

    }
}
