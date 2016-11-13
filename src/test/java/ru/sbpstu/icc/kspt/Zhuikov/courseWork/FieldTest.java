package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import org.junit.Test;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.CellColor;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.FieldItem;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;

import static org.junit.Assert.assertEquals;

public class FieldTest {

    @Test
    public void testInitialization() {

        Field field = new Field(9);

        assertEquals(CellColor.BLACK, field.getColor(0, 0));
        assertEquals(CellColor.WHITE, field.getColor(0, 1));
        assertEquals(CellColor.WHITE, field.getColor(1, 1));
        assertEquals(CellColor.BLACK, field.getColor(2, 2));
    }

    @Test
    public void testPathBetweenCells1() {  // пустое поле

        Field field = new Field(9);
        assertEquals(true, field.foo(new Coordinates(16, 8), 0));
        assertEquals(true, field.foo(new Coordinates(0, 8), 10));
    }

    @Test
    public void testPathBetweenCells2() { // "перегородка" по вертикали

        Field field = new Field(9);
        for (int i = 0; i <= field.getRealSize() - 1; i+=2) {
            field.setItem(FieldItem.BARRIER, i, 7);
        }

        assertEquals(true, field.foo(new Coordinates(16, 8), 0));
        assertEquals(true, field.foo(new Coordinates(16, 0), 0));
    }

    @Test
    public void testPathBetweenCells3() { // "перегородка" по горизонтали

        Field field = new Field(9);
        for (int i = 0; i <= field.getRealSize() - 1; i+=2) {
            field.setItem(FieldItem.BARRIER, 7, i);
        }

        assertEquals(true,  field.foo(new Coordinates(0, 4), 2));
        assertEquals(false, field.foo(new Coordinates(0, 4), 10));
    }

    @Test
    public void testPathBetweenCells4() { // закрытая фишка

        Field field = new Field(9);
        for (int i = 0; i <= field.getRealSize() - 1; i+=2) {
            field.setItem(FieldItem.BARRIER, i, 7);
            field.setItem(FieldItem.BARRIER, 7, i);
        }

        assertEquals(true,  field.foo(new Coordinates(0, 8), 6));
        assertEquals(false, field.foo(new Coordinates(0, 8), 16));
    }

}
