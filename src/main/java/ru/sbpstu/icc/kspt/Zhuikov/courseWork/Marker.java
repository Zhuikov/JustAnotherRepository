package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class Marker extends Item {


    Marker() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Marker ")
                .append(vertical)
                .append(" ")
                .append(horizontal)
                .append("]");

        return sb.toString();
    }
}
