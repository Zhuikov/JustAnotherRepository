package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class Field {

    private static final int MAX_FIELD_SIZE = 30;
    private static final int MIN_FIELD_SIZE = 7;
    private final int realSize;
    private Item[][] field;

    public Field(int size) {

        if ((size < 0) || (size > MAX_FIELD_SIZE) || (size % 2 == 0)) {
            throw new IllegalArgumentException("size of field must be odd-numbered, more than " +
                    MIN_FIELD_SIZE + " and less than " + MAX_FIELD_SIZE);
        }

        realSize = size * 2 - 1;
        field = new Item[realSize][realSize];
        for (int i = 0; i < realSize; i++) {
            for (int j = 0; j < realSize; j++) {
                field[i][j] = null; //todo EmptyItem
            }
        }

    }

    public Field() {
        this(9);
    }

    void printField() {

        for (int i = 0; i < realSize; i++) {
            for (int j = 0; j < realSize; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }

    void setItem(Item item, int vertical, int horizontal) {
        item.setHorizontal(horizontal);
        item.setVertical(vertical);
        field[vertical][horizontal] = item;
    }

}
