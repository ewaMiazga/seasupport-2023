package src.appActions;

import javafx.util.Pair;
import src.app.DataBase;
import src.logic.PriceListEntity;

import java.util.Vector;

public class PortInformationsActions {
    public Vector<Pair<String, Integer>> getPrices(int listId){
        Vector<Pair<String, Integer>> prices = new Vector<Pair<String, Integer>>();
        PriceListEntity list = DataBase.getInstance().getPriceList(listId);
        prices.add(new Pair<>("LAUNDRY", list.getLaundry().intValue()));
        prices.add(new Pair<>("DRYING_ROOM", list.getDryingRoom().intValue()));
        prices.add(new Pair<>("WATER", list.getWater().intValue()));
        prices.add(new Pair<>("SHOWER", list.getShower().intValue()));
        prices.add(new Pair<>("SAUNA", list.getSauna().intValue()));
        prices.add(new Pair<>("PLACE_LESS_7M", (int) list.getPlaceLess7M()));
        prices.add(new Pair<>("PLACE_7_12M", (int) list.getPlace712M()));
        prices.add(new Pair<>("PLACE_12_17M", (int) list.getPlace1217M()));
        prices.add(new Pair<>("PLACE_17_20M", (int) list.getPlace1720M()));
        prices.add(new Pair<>("PLACE_MORE_20M", (int) list.getPlaceMore20M()));
        return prices;
    }
}
