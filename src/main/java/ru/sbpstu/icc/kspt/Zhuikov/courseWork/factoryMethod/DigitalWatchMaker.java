package ru.sbpstu.icc.kspt.Zhuikov.courseWork.factoryMethod;


public class DigitalWatchMaker implements WatchMaker{

    public Watch createWatch() {
        return new DigitalWatch();
    }

}
