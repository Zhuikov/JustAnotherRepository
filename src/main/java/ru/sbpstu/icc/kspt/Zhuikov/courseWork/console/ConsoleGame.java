package ru.sbpstu.icc.kspt.Zhuikov.courseWork.console;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.QuoridorGame;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.PlayerPosition;

public class ConsoleGame {

    private static QuoridorGame game = new QuoridorGame(2);
    private static ConsoleDrawer drawer = new ConsoleDrawer(game);

    public static void main(String[] args) {

        drawer.drawPlayerInformation(PlayerPosition.TOP);
        drawer.drawField();
        drawer.drawPlayerInformation(PlayerPosition.BOTTOM);
        drawer.drawTurn();
        drawer.drawHelp();
        
        try {
            game.placeBarrier(4, 3, BarrierPosition.VERTICAL);
        } catch (Exception e) {
            System.out.println("я не хочу это ловить, потом будет хорошо");
        }

        System.out.println();
        drawer.drawPlayerInformation(PlayerPosition.TOP);
        drawer.drawField();
        drawer.drawPlayerInformation(PlayerPosition.BOTTOM);
        drawer.drawTurn();

    }

}
