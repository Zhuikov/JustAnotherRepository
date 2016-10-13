package ru.sbpstu.icc.kspt.Zhuikov.courseWork.factoryMethod;


import java.util.Date;

public class DigitalWatch implements Watch {

    public void showTime() {
        System.out.println(new Date());
    }

}
