package ru.sbpstu.icc.kspt.Zhuikov.courseWork.console;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;

public class Command {

    private CommandType commandType;
    private Coordinates coordinates;
    private BarrierPosition barrierPosition;

    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public BarrierPosition getBarrierPosition() {
        return barrierPosition;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setBarrierPosition(BarrierPosition barrierPosition) {
        this.barrierPosition = barrierPosition;
    }
}
