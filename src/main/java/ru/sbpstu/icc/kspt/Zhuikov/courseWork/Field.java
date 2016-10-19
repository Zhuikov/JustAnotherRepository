package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class Field {

    static final int size = 9;
    private Item[][] field = new Item[size][size];

    Field() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = null;
            }
        }

    }

    void printField(int x, int y) {
        System.out.println(field[x][y]);
    }

    void setItem(Item item, int horizontal, int vertical) {
        item.setHorizontal(horizontal);
        item.setVertical(vertical);
        field[horizontal][vertical] = item;
    }

}
