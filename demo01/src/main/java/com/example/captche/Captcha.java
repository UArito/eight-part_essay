package com.example.captche;

import java.util.Random;

public class Captcha {

    private static final Random rand = new Random();

    public static String[] generate() {
        int op = rand.nextInt(4); // 生成0到3之间的随机整数，分别代表加减乘除
        int a = 0, b = 0, result = 0;
        String operator = "";
        switch (op) {
            case 0:
                a = rand.nextInt(10) + 1; // 生成1到10之间的随机整数
                b = rand.nextInt(10) + 1; // 生成1到10之间的随机整数
                result = a + b;
                operator = "+";
                break;
            case 1:
                a = rand.nextInt(20) + 1; // 生成1到20之间的随机整数
                b = rand.nextInt(10) + 1; // 生成1到10之间的随机整数
                if (a < b) { // 如果a小于b，则交换a和b的值
                    int temp = a;
                    a = b;
                    b = temp;
                }
                result = a - b;
                operator = "-";
                break;
            case 2:
                a = rand.nextInt(10) + 1; // 生成1到10之间的随机整数
                b = rand.nextInt(10) + 1; // 生成1到10之间的随机整数
                result = a * b;
                operator = "*";
                break;
            case 3:
                b = rand.nextInt(10) + 1; // 生成1到10之间的随机整数
                result = rand.nextInt(10) + 1; // 生成1到10之间的随机整数
                a = b * result;
                operator = "/";
                break;
        }
        if (result > 100 || result < 0 || a > 100) { // 如果计算结果大于100或小于0，或者除数大于100，则重新生成一组题目
            return generate();
        }
        String captcha = String.format("%d %s %d", a, operator, b);
        String[] resultArray = new String[2]; // 创建一个包含验证码和答案的字符串数组
        resultArray[0] = captcha;
        resultArray[1] = String.valueOf(result); // 将答案转换为字符串类型
        return resultArray;
    }

    public static void main(String[] args) {
        String[] captcha = Captcha.generate();
        System.out.println(captcha[0]);
        System.out.println(captcha[1]);
    }
}
