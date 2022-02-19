package com.jef.thread.synchronizedTest;

/**
 * 两个线程访问同一对象的不同的synchronized方法
 * @author Jef
 * @date 2020/7/23
 */
public class SynchronizedSceneFive implements Runnable {
    static SynchronizedSceneFive ss1 = new SynchronizedSceneFive();

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(ss1);
        Thread t2 = new Thread(ss1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("运行完成");
    }

    @Override
    public void run() {
        // 模拟两个线程同时访问不同的synchronized方法
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1() {
        System.out.println("method1开始执行:" + Thread.currentThread().getName());
        try {
            // 模拟执行内容
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("method1执行结束:" + Thread.currentThread().getName());
    }

    public synchronized void method2() {
        System.out.println("method2开始执行:" + Thread.currentThread().getName());
        try {
            // 模拟执行内容
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("method2执行结束:" + Thread.currentThread().getName());
    }
}