package com.vther.concurrent.period1.thread;


import java.time.Duration;
import java.time.Instant;

public class _07_GracefullyStopAThread {
    public static void main(String[] args) {

        System.out.println("Main Thread start");

        WorkThread1 workThread1 = new WorkThread1();
        workThread1.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workThread1.shutdown();


        WorkThread2 workThread2 = new WorkThread2();
        workThread2.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workThread2.interrupt();

        Instant start = Instant.now();
        ThreadService threadService = new ThreadService();
        threadService.execute(() -> {
            System.out.println("runnable in executeThread start");
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable in executeThread end");
        });
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadService.shutdown();

        System.out.println(Duration.between(start,Instant.now()).getSeconds());
    }

    private static class WorkThread1 extends Thread {
        // 用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。
        private volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
            }
            System.out.println("WorkThread1 end");
        }

        public void shutdown() {
            this.flag = false;
        }
    }

    private static class WorkThread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    break;//return
                }
            }
            System.out.println("WorkThread2 end");
        }
    }

    private static class ThreadService {
        Thread executeThread;

        void execute(Runnable runnable) {
            executeThread = new Thread(() -> {
                System.out.println("executeThread start");
                Thread runner = new Thread(runnable);
                runner.setDaemon(true);
                runner.start();

                try {
                    runner.join();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
                System.out.println("executeThread end");
            });
            executeThread.start();
        }

        void shutdown() {
            executeThread.interrupt();
        }
    }

}
