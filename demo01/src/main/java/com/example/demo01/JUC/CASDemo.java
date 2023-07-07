package com.example.demo01.JUC;

import com.example.demo01.day01.Day02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CASDemo {
    public void reentrantLockDemo(){
        /*sync.lock();
         * extends AbstractQueuedSynchronizer
         * */
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.tryLock();
        reentrantLock.newCondition();
        try {
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int num1 = 0;
    static Integer num = 0;
    static AtomicInteger num2 = new AtomicInteger();
    public static void main(String[] args) {
        /**
         *  非线程安全
         *
         * */
//        for (int i = 0; i <3 ; i++) {
//            Thread thread =new Thread(()->{
//                while (num<1000){
//                    System.out.println("Thread name:"+Thread.currentThread().getName()+":"+num++);
//                }
//            });
//            thread.start();
//        }

        /**
         *  AtomicInteger
         *
         * */
//        for (int i = 0; i <3 ; i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while(num2.get()<1000){
//                        System.out.println("Thread name:"+Thread.currentThread().getName()+":"+num2.incrementAndGet());
//                    }
//                }
//            });
//            thread.start();
//        }
/**
 *  synchronized
 *
 * */
        for (int i = 0; i <3 ; i++) {
            synchronized (Day02.class){
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(num<1000){
                            System.out.println("Thread name:"+Thread.currentThread().getName()+":"+num++);
                        }
                    }
                });
                thread.start();
            }
        }
    }
}
