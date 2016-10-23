package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;


public class Coordinates {

    private int vertical = -1;
    private int horizontal = -1;

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public Coordinates(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (vertical != that.vertical) return false;
        return horizontal == that.horizontal;

    }

    @Override
    public int hashCode() {
        int result = vertical;
        result = 31 * result + horizontal;
        return result;
    }
}
