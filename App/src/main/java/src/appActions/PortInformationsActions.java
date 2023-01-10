package src.appActions;

import javafx.util.Pair;
import src.app.DataBase;
import src.app.PriceListDialog;
import src.logic.PortsEntity;
import src.logic.PriceListEntity;

import java.util.Vector;

/**
 * The type Port Information Actions.
 */
public class PortInformationsActions {
    /**
     * GetPrices.
     *
     * Get data to Prices Window.
     * @param list PriceListEntity
     */
    public Vector<Pair<String, String>> getPrices(PriceListEntity list) {
        Vector<Pair<String, String>> prices = new Vector<Pair<String, String>>();
        if (list.getLaundry() != null) prices.add(new Pair<>("LAUNDRY", list.getLaundry().toString()));
        else prices.add(new Pair<>("LAUNDRY", "Not available"));
        if (list.getDryingRoom() != null) prices.add(new Pair<>("DRYING_ROOM", list.getDryingRoom().toString()));
        else prices.add(new Pair<>("DRYING_ROOM", "Not available"));
        if (list.getWater() != null) prices.add(new Pair<>("WATER", list.getWater().toString()));
        else prices.add(new Pair<>("WATER", "Not available"));
        if (list.getShower() != null) prices.add(new Pair<>("SHOWER", list.getShower().toString()));
        else prices.add(new Pair<>("SHOWER", "Not available"));
        if (list.getSauna() != null) prices.add(new Pair<>("SAUNA", list.getSauna().toString()));
        else prices.add(new Pair<>("SAUNA", "Not available"));
        if (list.getPlaceLess7M() != null) prices.add(new Pair<>("PLACE_LESS_7M", list.getPlaceLess7M().toString()));
        else prices.add(new Pair<>("PLACE_LESS_7M", "Not available"));
        if (list.getPlace712M() != null) prices.add(new Pair<>("PLACE_7_12M", list.getPlace712M().toString()));
        else prices.add(new Pair<>("PLACE_7_12M", "Not available"));
        if (list.getLaundry() != null) prices.add(new Pair<>("PLACE_12_17M", list.getPlace1217M().toString()));
        else prices.add(new Pair<>("PLACE_12_17M", "Not available"));
        if (list.getPlace1217M() != null) prices.add(new Pair<>("PLACE_17_20M", list.getPlace1720M().toString()));
        else prices.add(new Pair<>("PLACE_17_20M", "Not available"));
        if (list.getPlaceMore20M() != null) prices.add(new Pair<>("PLACE_MORE_20M", list.getPlaceMore20M().toString()));
        else prices.add(new Pair<>("PLACE_MORE_20M", "Not available"));
        return prices;
    }
}
