package ru.sbpstu.icc.kspt.Zhuikov.courseWork.console;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Player;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.QuoridorGame;

import java.util.Scanner;

public class ConsoleGame {

    private static QuoridorGame game = new QuoridorGame(2);
    private static ConsoleDrawer drawer = new ConsoleDrawer(game);
    private static CommandReader reader = new CommandReader();

    public static void main(String[] args) {

        ConsoleGame consoleGame = new ConsoleGame();
        consoleGame.launch();

    }

    public void launch() {

        Scanner in = new Scanner(System.in);
        while (!game.isOver()) {

            drawer.drawPlayerInformation(Player.TOP);
            drawer.drawField();
            drawer.drawPlayerInformation(Player.BOTTOM);
            drawer.drawTurn();
            try {
                Command command = reader.read(in.nextLine());
                switch (command.getCommandType()) {
                    case BARRIER:
                        game.placeBarrier(command.getCoordinates(), command.getBarrierPosition());
                        break;
                    case MARKER:
                        game.moveMarker(command.getCoordinates());
                        break;
                    case HELP:
                        drawer.drawHelp();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
