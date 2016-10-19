package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


public class JustAnotherClass {

    public static void main(String[] args) {

        Field field = new Field();
        field.printField(3, 4);
        Item item = new Item();
        field.setItem(item, 3, 4);
        field.printField(3, 4);
    }

}
