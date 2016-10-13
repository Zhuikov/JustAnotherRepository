package ru.sbpstu.icc.kspt.Zhuikov.courseWork.factoryMethod;


public class FactoryMethod {

    public static void main(String[] args) {

        WatchMaker watchMaker = new DigitalWatchMaker();

        Watch watch = watchMaker.createWatch();
        watch.showTime();

    }

}

