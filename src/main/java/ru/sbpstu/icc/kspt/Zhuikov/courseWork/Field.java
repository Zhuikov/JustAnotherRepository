package ru.sbpstu.icc.kspt.Zhuikov.courseWork;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.CellColor;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.FieldItem;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.FieldCoordinatesException;

public class Field {

    private static final int MAX_FIELD_SIZE = 30;
    private static final int MIN_FIELD_SIZE = 7;
    private final int realSize;
    private Cell[][] field;

    public int getRealSize() {
        return realSize;
    }

    private class Cell {

        private CellColor color;
        private FieldItem fieldItem;

        CellColor getColor() {
            return color;
        }

        FieldItem getFieldItem() {
            return fieldItem;
        }

        void setColor(CellColor color) {
            this.color = color;
        }

        void setFieldItem(FieldItem fieldItem) {
            this.fieldItem = fieldItem;
        }

        Cell(FieldItem fieldItem) {
            this.fieldItem = fieldItem;
        }

    }

    public Field(int size) {

        if ((size < 0) || (size > MAX_FIELD_SIZE) || (size % 2 == 0)) {
            throw new IllegalArgumentException("size of field must be odd-numbered, more than " +
                    MIN_FIELD_SIZE + " and less than " + MAX_FIELD_SIZE);
        }

        realSize = size * 2 - 1;
        field = new Cell[realSize][realSize];
        for (int i = 0; i < realSize; i++) {
            for (int j = 0; j < realSize; j++) {
                field[i][j] = new Cell(FieldItem.EMPTY);
                if ((i % 2 == 0) && (j % 2 == 0)) {
                    field[i][j].setColor(CellColor.BLACK);
                } else {
                    field[i][j].setColor(CellColor.WHITE);
                }
            }
        }

    }

    public Field() {
        this(9);
    }

    public FieldItem getItem(int vertical, int horizontal) throws FieldCoordinatesException {

        try {
            return field[vertical][horizontal].getFieldItem();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new FieldCoordinatesException("wrong coordinates " + vertical + " " + horizontal);
        }

    }

    public CellColor getColor(int vertical, int horizontal) {

        return field[vertical][horizontal].getColor();

    }

    public void setItem(FieldItem item, int vertical, int horizontal) {

        field[vertical][horizontal].setFieldItem(item);

    }

}
