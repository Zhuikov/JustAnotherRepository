package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;

public class PlayerInformation {

    private int barriers = 0;
    private Coordinates coordinates;

    public int getBarriers() {
        return barriers;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public PlayerInformation(int barriers, Coordinates coordinates) {
        this.barriers = barriers;
        this.coordinates = coordinates;
    }

}
