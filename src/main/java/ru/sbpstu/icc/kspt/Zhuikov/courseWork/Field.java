package ru.sbpstu.icc.kspt.Zhuikov.courseWork;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.CellColor;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.ItemType;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Empty;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        private Item item;

        void setItem(Item item) {
            this.item = item;
        }

        Cell(Item item, CellColor color) {
            this.item = item;
            this.color = color;
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
                if ((i % 2 == 0) && (j % 2 == 0)) {
                    field[i][j] = new Cell(new Empty(i, j), CellColor.BLACK);
                } else {
                    field[i][j] = new Cell(new Empty(i, j), CellColor.WHITE);
                }
            }
        }

    }

    public Field() {
        this(9);
    }

    public Item getItem(int vertical, int horizontal) {

        return field[vertical][horizontal].item;

    }

    public CellColor getColor(int vertical, int horizontal) {

        return field[vertical][horizontal].color;

    }

    public void setItem(Item item, int vertical, int horizontal) {

        field[vertical][horizontal].setItem(item);
    }

    public boolean foo(Coordinates marker, int rowNumber) { // todo: rename

        boolean used[][] = new boolean[realSize][realSize]; // todo: used[i][j] = false ?
        Queue<Coordinates> queue = new LinkedList<>();

        queue.add(marker);

        while (!queue.isEmpty()) {

//          for (Coordinates coordinates : queue) {
//              System.out.print(coordinates + " ");
//          }
//          System.out.println();

            if (queue.element().getVertical() == rowNumber) {
                return true;
            }

            for (Coordinates neighbour : getNeighbours(queue.element())) {
                try {
                    if (!used[neighbour.getVertical()][neighbour.getHorizontal()] &&   // todo: шлифануть бы тут
                            getItem((queue.element().getVertical() + neighbour.getVertical()) / 2,
                                    (queue.element().getHorizontal() + neighbour.getHorizontal()) / 2).getType() != ItemType.BARRIER &&
                            !queue.contains(new Coordinates(neighbour.getVertical(), neighbour.getHorizontal()))) {
                        queue.add(neighbour);
                    }
                } catch (ArrayIndexOutOfBoundsException e) { }
            }

            used[queue.element().getVertical()][queue.element().getHorizontal()] = true;
            queue.remove();
        }

        return false;
    }

    private List<Coordinates> getNeighbours(Coordinates init) {

        List<Coordinates> neighbours = new ArrayList<>();

        neighbours.add(new Coordinates(init.getVertical() - 2, init.getHorizontal()));
        neighbours.add(new Coordinates(init.getVertical(), init.getHorizontal() - 2));
        neighbours.add(new Coordinates(init.getVertical() + 2, init.getHorizontal()));
        neighbours.add(new Coordinates(init.getVertical(), init.getHorizontal() + 2));

        return neighbours;
    }

}
