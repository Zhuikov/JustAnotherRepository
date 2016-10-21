package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class JustAnotherClass {

    public static void main(String[] args) {

        Field field = new Field();
        field.printField();
        field.setItem(FieldItem.BARRIER, 4, 5);
        field.setItem(FieldItem.MARKER, 0, 8);
        System.out.println();
        field.printField();
    }

}
