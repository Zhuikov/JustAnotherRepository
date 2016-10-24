package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class Field {

    private static final int MAX_FIELD_SIZE = 30;
    private static final int MIN_FIELD_SIZE = 7;
    private final int realSize;
    private Cell[][] field;

    public int getRealSize() {
        return realSize;
    }

    private class Cell {

        private String color;
        private FieldItem fieldItem;

        String getColor() {
            return color;
        }

        FieldItem getFieldItem() {
            return fieldItem;
        }

        void setColor(String color) {
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
                    field[i][j].setColor("black");
                } else {
                    field[i][j].setColor("white");
                }
            }
        }

    }

    public Field() {
        this(9);
    }

    public FieldItem getItem(int vertical, int horizontal) {

        return field[vertical][horizontal].getFieldItem();

    }

    public String getColor(int vertical, int horizontal) {

        return field[vertical][horizontal].getColor();

    }

    public void setItem(FieldItem item, int vertical, int horizontal) {

        field[vertical][horizontal].setFieldItem(item);

    }

}
