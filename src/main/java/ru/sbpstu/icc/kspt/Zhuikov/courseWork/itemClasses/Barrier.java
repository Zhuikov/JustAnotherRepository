package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.*;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.CellIsNotEmptyException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.FieldCoordinatesException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ImpossibleToSetException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;

import java.util.ArrayList;
import java.util.List;

public class Barrier extends Item {

    private static final int length = 2;
    private final List<Coordinates> allCoordinates = new ArrayList<Coordinates>();

    public List<Coordinates> getAllCoordinates() {
        return allCoordinates;
    }

    public Barrier(Field field) {
        this.field = field;
    }

    public void placeBarrier(int vertical, int horizontal, BarrierPosition position) throws ItemFieldException {

        checkPlace(vertical, horizontal, position);
        setBarrier(vertical, horizontal, position);
    }

    private boolean checkPlace(int vertical, int horizontal, BarrierPosition position) throws ItemFieldException {

//        if (vertical == field.getRealSize() || vertical == 0 ||
//                horizontal == field.getRealSize() || horizontal == 0) {
//            throw new ImpossibleToSetException("impossible to place barrier here: need more space");
//        }

        if (position == BarrierPosition.VERTICAL) {                      //todo что-то сделать
            for (int i = vertical - length + 1; i <= vertical + length - 1; i++) {
                try {
                    if (field.getItem(i, horizontal) != FieldItem.EMPTY) {
                        throw new CellIsNotEmptyException("impossible to place barrier on occupied field " +
                                vertical + " " + horizontal);
                    }
                    if (field.getColor(i, horizontal) == CellColor.BLACK) {
                        throw new ImpossibleToSetException("impossible to set barrier on black cell");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new FieldCoordinatesException("impossible to place barrier on " + vertical + " " + horizontal);
                }
            }

        } else if (position == BarrierPosition.HORIZONTAL) {
            for (int i = horizontal - length + 1; i <= horizontal + length - 1; i++) {
                try {
                    if (field.getItem(vertical, i) != FieldItem.EMPTY) {
                        throw new CellIsNotEmptyException("impossible to place barrier on field " +
                                vertical + " " + horizontal);
                    }
                    if (field.getColor(vertical, i) == CellColor.BLACK) {
                        throw new ImpossibleToSetException("impossible to set barrier on black cell");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new FieldCoordinatesException("impossible to place barrier on " + vertical + " " + horizontal);
                }
            }
        }

        return true;
    }

    private void setBarrier(int vertical, int horizontal, BarrierPosition position) {

        if (position == BarrierPosition.VERTICAL) {
            for (int i = vertical - length + 1; i <= vertical + length - 1; i++) {
                field.setItem(FieldItem.BARRIER, i, horizontal);
                allCoordinates.add(new Coordinates(i, horizontal));
            }

        } else if (position == BarrierPosition.HORIZONTAL) {
            for (int i = horizontal - length + 1; i <= horizontal + length - 1; i++) {
                field.setItem(FieldItem.BARRIER, vertical, i);
                allCoordinates.add(new Coordinates(vertical, i));
            }
        }

        coordinates.setVertical(vertical);
        coordinates.setHorizontal(horizontal);
    }
}
