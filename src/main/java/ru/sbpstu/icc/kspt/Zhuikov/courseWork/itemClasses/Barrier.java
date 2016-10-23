package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.FieldItem;

import java.util.ArrayList;
import java.util.List;

public class Barrier extends Item {

    private static final int length = 2;
    private final List<Coordinates> allCoordinates = new ArrayList<Coordinates>();

    public List<Coordinates> getAllCoordinates() {
        return allCoordinates;
    }

    public Barrier(Field field) {
        super(field);
    }

    public void toField(int vertical, int horizontal, String position) throws Exception {

        checkArguments(position);
        checkPlace(vertical, horizontal, position);
        setBarrier(vertical, horizontal, position);
    }

    private void checkArguments(String position) {

        if (!position.equals("vertical") && !position.equals("horizontal")) {
            throw new IllegalArgumentException("wrong argument \"" + position + "\" in Barrier");
        }

    }

    private boolean checkPlace(int vertical, int horizontal, String position) throws Exception {

        if (position.equals("vertical")) {                      //todo что-то сделать
            for (int i = vertical - length + 1; i <= vertical + length - 1; i++) {
                if (field.getItem(i, horizontal) != FieldItem.EMPTY) {
                    throw new Exception("impossible to place barrier on field " +
                            vertical + " " + horizontal);
                }
                if (field.getColor(i, horizontal).equals("black")) {
                   throw new Exception("impossible to set barrier on black cell");
                }
            }

        } else if (position.equals("horizontal")) {
            for (int i = horizontal - length + 1; i <= horizontal + length - 1; i++) {
                if (field.getItem(vertical, i) != FieldItem.EMPTY) {
                    throw new Exception("impossible to place barrier on field " +
                            vertical + " " + horizontal);
                }
                if (field.getColor(vertical, i).equals("black")) {
                    throw new Exception("impossible to set barrier on black cell");
                }
            }
        }

        return true;

//        int a = 0;
//        Coordinates coordinates = new Coordinates(-1, -1);
//        if (position.equals("vertical")) {
//            a = vertical;
//            coordinates.setHorizontal(horizontal);
//        } else if (position.equals("horizontal")) {
//            a = horizontal;
//            coordinates.setVertical(vertical);
//        }
//
//        for (int i = a - length + 1; i <= a + length - 1; i++) {
//
//            if (position.equals("vertical")) {
//                coordinates.setHorizontal(i);
//            } else if (position.equals("horizontal")){
//                coordinates.setVertical(i);
//            }
//
//            if (field.getItem(coordinates) != FieldItem.EMPTY) {
//                throw new Exception("impossible to place barrier on field " +
//                        vertical + " " + horizontal);
//            }
//            if (field.getColor(coordinates).equals("black")) {
//                throw new Exception("impossible to set barrier on black cell");
//            }
//        }

    }

    private void setBarrier(int vertical, int horizontal, String position) {

        if (position.equals("vertical")) {
            for (int i = vertical - length + 1; i <= vertical + length - 1; i++) {
                field.setItem(FieldItem.BARRIER, i, horizontal);
                allCoordinates.add(new Coordinates(i, horizontal));
            }

        } else if (position.equals("horizontal")) {
            for (int i = horizontal - length + 1; i <= horizontal + length - 1; i++) {
                field.setItem(FieldItem.BARRIER, vertical, i);
                allCoordinates.add(new Coordinates(vertical, i));
            }
        }


        coordinates.setVertical(vertical);
        coordinates.setHorizontal(horizontal);

    }
}
