//package ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums;
//
//
//import ru.sbpstu.icc.kspt.Zhuikov.courseWork.PlayerInformation;
//import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
//import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
//import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
//import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;
//
//import java.util.List;
//
//public enum PlayerPosition {
//
//    TOP,
//    BOTTOM,
//    RIGHT,
//    LEFT;
//
//    private Marker marker = null;
//    private List<Barrier> barriers = null;  // todo нет поля, поэтому надо откуда-то брать бьрьеры
//    private int barriersNumber = 0;
//
////    PlayerPosition(Marker marker, List<Barrier> barriers) {
////        this.barriers = barriers;
////        this.marker = marker;
////        barriersNumber = barriers.size();
////    }
//
//    public void moveMarker(int vertical, int horizontal) throws ItemFieldException {
//
//        marker.moveTo(vertical, horizontal);
//    }
//
//    public void placeBarrier(int vertical, int horizontal, BarrierPosition position)
//            throws NoBarriersException, ItemFieldException {
//
//        if (barriersNumber == 0) {
//            throw new NoBarriersException("you have no barriers");
//        }
//
//        barriers.get(barriersNumber - 1).placeBarrier(vertical, horizontal, position);
//        barriersNumber--;
//    }
//
//    public PlayerInformation getInformation() {
//
//        return new PlayerInformation(barriersNumber, marker.getCoordinates());
//    }
//}
