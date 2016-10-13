package ru.sbpstu.icc.kspt.Zhuikov.courseWork.factoryMethod;


public class QuartzWatchMaker implements WatchMaker{

    public Watch createWatch() {
        return new QuartzWatch();
    }

}