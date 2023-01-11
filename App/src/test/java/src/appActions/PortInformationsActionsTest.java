package src.appActions;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import src.logic.PriceListEntity;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PortInformationsActionsTest {


    Short s = 10;
    PriceListEntity priceList = new PriceListEntity(1, s, s, s, s, s, s, s, s, s, s);

    PriceListEntity priceListEverythingNotAvailable = new PriceListEntity(1, null, null, null, null, null, null, null, null, null, null);
    PriceListEntity priceListSomeAvailableSomeNot = new PriceListEntity(1, null, s, s, null, s, s, null, s, s, null);
    PortInformationsActions portInformationsActions = new PortInformationsActions();

}
    /*@Test
    void testGetPricesAllServicesAvailable() {
        Vector<Pair<String, String>> prices = new Vector<Pair<String, String>>();
        prices.add(new Pair<>("LAUNDRY", s.toString()));
        prices.add(new Pair<>("DRYING_ROOM", s.toString()));
        prices.add(new Pair<>("WATER", s.toString()));
        prices.add(new Pair<>("SHOWER", s.toString()));
        prices.add(new Pair<>("SAUNA", s.toString()));
        prices.add(new Pair<>("PLACE_LESS_7M", s.toString()));
        prices.add(new Pair<>("PLACE_7_12M", s.toString()));
        prices.add(new Pair<>("PLACE_12_17M", s.toString()));
        prices.add(new Pair<>("PLACE_17_20M", s.toString()));
        prices.add(new Pair<>("PLACE_MORE_20M", s.toString()));

        var returnedVector = portInformationsActions.getPrices(priceList);
        assertEquals(prices, returnedVector);
    }

    @Test
    void testGetPricesAllServicesNotAvailable() {
        Vector<Pair<String, String>> prices = new Vector<Pair<String, String>>();
        prices.add(new Pair<>("LAUNDRY", "Not available"));
        prices.add(new Pair<>("DRYING_ROOM", "Not available"));
        prices.add(new Pair<>("WATER", "Not available"));
        prices.add(new Pair<>("SHOWER", "Not available"));
        prices.add(new Pair<>("SAUNA", "Not available"));
        prices.add(new Pair<>("PLACE_LESS_7M", "Not available"));
        prices.add(new Pair<>("PLACE_7_12M", "Not available"));
        prices.add(new Pair<>("PLACE_12_17M", "Not available"));
        prices.add(new Pair<>("PLACE_17_20M", "Not available"));
        prices.add(new Pair<>("PLACE_MORE_20M", "Not available"));

        var returnedVector = portInformationsActions.getPrices(priceListEverythingNotAvailable);
        assertEquals(prices, returnedVector);
    }


    @Test
    void testGetPricesSomeServicesAvailable() {
        Vector<Pair<String, String>> prices = new Vector<Pair<String, String>>();
        prices.add(new Pair<>("LAUNDRY", "Not available"));
        prices.add(new Pair<>("DRYING_ROOM", s.toString()));
        prices.add(new Pair<>("WATER", s.toString()));
        prices.add(new Pair<>("SHOWER", "Not available"));
        prices.add(new Pair<>("SAUNA", s.toString()));
        prices.add(new Pair<>("PLACE_LESS_7M", s.toString()));
        prices.add(new Pair<>("PLACE_7_12M","Not available"));
        prices.add(new Pair<>("PLACE_12_17M", s.toString()));
        prices.add(new Pair<>("PLACE_17_20M", s.toString()));
        prices.add(new Pair<>("PLACE_MORE_20M", "Not available"));

        var returnedVector = portInformationsActions.getPrices(priceListSomeAvailableSomeNot);
        assertEquals(prices, returnedVector);
    }
}*/