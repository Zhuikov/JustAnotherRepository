package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class Item {

    private int horizontal = -1;
    private int vertical   = -1;
    private Field field    = null;

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
        sb.append("item: ")
                .append(horizontal)
                .append(" ")
                .append(vertical);

        return sb.toString();
    }
}
