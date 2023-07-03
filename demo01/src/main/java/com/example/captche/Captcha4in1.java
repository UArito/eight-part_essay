package com.example.captche;

import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;

import java.io.FileOutputStream;

/**
 * 验证码
 */
public class Captcha4in1 {
    public static void main(String[] args)throws Exception {
        String path = "D:\\demo01\\";
        //png图
        SpecCaptcha captcha = new SpecCaptcha(130, 40);
        FileOutputStream outputStream = new FileOutputStream(path + "0png类型.png");
        System.out.println(captcha.text());
        captcha.out(outputStream);
        //gif动图
        GifCaptcha gifCaptcha = new GifCaptcha(130, 40);
        FileOutputStream outputStream1 = new FileOutputStream(path + "1gif类型.gif");
        //设置纯大写字母验证码TYPE_ONLY_UPPER
        gifCaptcha.setCharType(Captcha.TYPE_ONLY_UPPER);
        //设置字体
        gifCaptcha.setFont(Captcha.FONT_5);
        System.out.println(gifCaptcha.text());
        gifCaptcha.out(outputStream1);
        //中文类型
        ChineseCaptcha chineseCaptcha = new ChineseCaptcha(130, 40);
        FileOutputStream outputStream2 = new FileOutputStream(path + "2中文类型.png");
        System.out.println(chineseCaptcha.text()); chineseCaptcha.out(outputStream2);
        //中文类型gif动图
        ChineseGifCaptcha chineseGifCaptcha = new ChineseGifCaptcha(130, 40);
        FileOutputStream outputStream3 = new FileOutputStream(path + "3中文类型动图.gif");
        System.out.println(chineseGifCaptcha.text()); chineseGifCaptcha.out(outputStream3);
        //算术类型
        ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(180, 40);
        FileOutputStream outputStream4 = new FileOutputStream(path + "4算术类型.png");
        //设置几位数的运算，几个数计算
        arithmeticCaptcha.setLen(3);
        //打印算式
        System.out.println(arithmeticCaptcha.getArithmeticString());
        //打印算式的结果
        System.out.println(arithmeticCaptcha.text());
        arithmeticCaptcha.out(outputStream4);
    }
}
