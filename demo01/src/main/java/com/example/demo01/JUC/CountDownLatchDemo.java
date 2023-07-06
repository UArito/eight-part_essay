package com.example.demo01.JUC;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static class searchTask implements Runnable{
        private Integer id;
        private CountDownLatch countDownLatch;

        public searchTask(Integer id, CountDownLatch countDownLatch) {
            this.id = id;
            this.countDownLatch = countDownLatch;
        }

        Random random = new Random();
        int i = random.nextInt(10);

        @Override
        public void run() {
            System.out.println("开始"+id+"搜索");
            try {
                Thread.sleep(i*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("花了"+i+"秒早到了"+id+"号龙珠");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        CountDownLatch countDownLatch = new CountDownLatch(integers.size());
        for (Integer id: integers){
            Thread thread = new Thread(new searchTask(id,countDownLatch));
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("找到啦！！！！！！！");
    }
}
