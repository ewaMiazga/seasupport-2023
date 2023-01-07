package src.appActions;

import jakarta.persistence.Tuple;
import src.app.DataBase;
import src.app.DataBase.*;
import src.logic.*;
import javafx.util.Pair;

import java.util.List;
import java.util.Vector;

public class PortsWindowActions {

    void createVisit(){
        // sprawdz dostepnosc w porcie
        // dodaj wizyte
        // zwroc info o ewentualnym bledzie
    }

    void endVisit(){
        // zakoncz wizyte podczas tworzenia jesli jakas by istniala
    }

    void updatePort(){

    }

    int getAvalibleSpace(String portId){
        // get number of visits in this port
        // places in port - number of visits
        return 0;
    }
    PortsEntity getPortById(String portId){
        PortsEntity port = DataBase.getInstance().getPort(portId);
        return port;
    }

    Vector<String> getPortInfo(String portId){
        Vector<String> informations = new Vector<>();
        // get from database info about prices, avalible places etc.
        return informations;
    }









}
