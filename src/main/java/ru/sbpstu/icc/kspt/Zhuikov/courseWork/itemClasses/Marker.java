package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.CellColor;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.ItemType;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.*;

public class Marker extends Item {

    public Marker(Field field, int vertical, int horizontal) {
        field.setItem(this, vertical, horizontal);
        this.field = field;
        type = ItemType.MARKER;
        coordinates.setVertical(vertical);
        coordinates.setHorizontal(horizontal);
    }

    public void moveTo(int vertical_, int horizontal_) throws ItemFieldException {

        checkPlace(vertical_, horizontal_); // todo ход через фишку
        setMarker(vertical_, horizontal_);
    }

    private void checkPlace(int vertical, int horizontal) throws ItemFieldException {

        try {
            field.getItem(vertical, horizontal);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new FieldCoordinatesException("impossible to place marker on " + vertical + " " + horizontal);
        }

        if (coordinates.equals(new Coordinates(vertical, horizontal))) {
            throw new SetToSameCellException("impossible to move to the same cell");
        }

        if (field.getColor(vertical, horizontal) == CellColor.WHITE) {
            throw new ImpossibleToSetException("impossible to set marker on white cell");
        }

        if (field.getItem(vertical, horizontal).getType() != ItemType.EMPTY) {
            throw new CellIsNotEmptyException("cell " + vertical + horizontal + " is not empty");
        }

        if (Math.sqrt((vertical - coordinates.getVertical()) * (vertical - coordinates.getVertical()) +
                (horizontal - coordinates.getHorizontal()) * (horizontal - coordinates.getHorizontal())) > 2.1) {
            throw new TooLongDistanceException("you can move just nearby cells");
        }

        if (field.getItem((this.coordinates.getVertical() + vertical) / 2,
                (this.coordinates.getHorizontal() + horizontal) / 2).getType() == ItemType.BARRIER) {
            throw new ImpossibleToSetException("impossible to jump over the barrier");
        }
    }

    private void setMarker(int vertical, int horizontal) {

        field.setItem(new Empty(coordinates.getVertical(), coordinates.getHorizontal()),
                coordinates.getVertical(), coordinates.getHorizontal()); // todo: придумать field.setField(Item);
        field.setItem(this, vertical, horizontal);
        coordinates.setVertical(vertical);
        coordinates.setHorizontal(horizontal);
    }
}
