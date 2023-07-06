package com.example.demo01.JUC;

import java.util.concurrent.locks.LockSupport;

public class TheadInterrupt {

    public static void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("123");
        });
        thread.start();
        System.out.println(111111);
        //boolean interrupted = Thread.interrupted();
        System.out.println(222);
        //System.out.println(interrupted);
        boolean interrupted1 = thread.isInterrupted();
        System.out.println(interrupted1);

    }

    public static void main(String[] args) throws InterruptedException {
        testInterrupt();
    }
}
