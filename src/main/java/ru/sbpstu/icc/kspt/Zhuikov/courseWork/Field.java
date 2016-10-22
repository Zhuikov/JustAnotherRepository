package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class Field {

    private static final int MAX_FIELD_SIZE = 30;
    private static final int MIN_FIELD_SIZE = 7;
    private final int realSize;
    private FieldItem[][] field;

    public Field(int size) {

        if ((size < 0) || (size > MAX_FIELD_SIZE) || (size % 2 == 0)) {
            throw new IllegalArgumentException("size of field must be odd-numbered, more than " +
                    MIN_FIELD_SIZE + " and less than " + MAX_FIELD_SIZE);
        }

        realSize = size * 2 - 1;
        field = new FieldItem[realSize][realSize];
        for (int i = 0; i < realSize; i++) {
            for (int j = 0; j < realSize; j++) {
                field[i][j] = FieldItem.EMPTY;
                if ((i % 2 == 0) && (j % 2 == 0)) {
                    //todo obj with color
                }
            }
        }

    }

    public Field() {
        this(9);
    }

    public void printField() {

        for (int i = 0; i < realSize; i++) {
            for (int j = 0; j < realSize; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }

    public FieldItem getItem(int vertical, int horizontal) {

        if (checkBounds(vertical, horizontal)) {
            return field[vertical][horizontal];
        }
        throw new IllegalArgumentException("wrong get indexes [" + vertical + " " + horizontal + "]");
    }

    private boolean checkBounds(int vertical, int horizontal) {

        return (vertical >= 0) && (vertical < realSize) &&
                (horizontal >= 0) && (horizontal < realSize);

    }

    public void setItem(FieldItem item, int vertical, int horizontal) {

        if (checkBounds(vertical, horizontal)) {
            field[vertical][horizontal] = item;
        }

    }

}
