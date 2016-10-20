package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class Item {

    protected int horizontal = -1;
    protected int vertical   = -1;

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) { this.horizontal = horizontal; }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) { this.vertical = vertical; }

    Item() {

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[item: ")
                .append(horizontal)
                .append(" ")
                .append(vertical)
                .append("]");

        return sb.toString();
    }
}
