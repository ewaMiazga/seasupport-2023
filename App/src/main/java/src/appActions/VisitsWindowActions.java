package src.appActions;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.chart.PieChart;
import javafx.util.Pair;
import src.logic.*;
import src.app.DataBase;

public class VisitsWindowActions {
    public int addShip(Vector<String> data){
        for(int i =0; i < data.size(); i++){
            if(data.get(i).equals(""))
                return 0;
        }
        if(shipInDataBase(data.get(0))) return 1;
        if(!data.get(3).chars().allMatch( Character::isDigit )) return 3;
        int n = Integer.valueOf(data.get(3));
        if(n > 30) return 4;
        ShipOwnersEntity owner = DataBase.getInstance().getOwner(data.get(4));
        if(owner == null) return 6;
        System.out.println(owner.getEmail());
        short len = Short.valueOf(data.get(3));
        ShipsEntity ship = new ShipsEntity(data.get(0), data.get(1), data.get(2), len, owner);
        System.out.println(ship.getShipName());
        DataBase.getInstance().addShip(ship);
        System.out.println("Kontrola");
        return 5;
    }

    private boolean shipInDataBase(String callSign){
        ShipsEntity s = DataBase.getInstance().getShip(callSign);
        if(s == null) return false;
        return true;
    }

    private boolean ownerInDataBase(String id){
        ShipOwnersEntity s = DataBase.getInstance().getOwner(id);
        if(s == null) return false;
        return true;
    }

    public int addVisit(Vector<String> data, LocalDate begin, LocalDate end, PortsEntity port, AllUsersEntity user){
        if(begin == null || end == null) return 8;

        Date dateBegin = Date.valueOf(begin);
        Date dateEnd = Date.valueOf(end);

        for(int i =0; i < data.size(); i++){
            if(data.get(i).equals(""))
                return 0;
        }

        if(begin.isBefore(LocalDate.now())) return 2;
        if(begin.isAfter(end)) return 3;
        if(!shipInDataBase(data.get(2))) return 4;
        if(!captianInDataBase(data.get(3))) return 5;

        ShipsEntity ship = DataBase.getInstance().getShip(data.get(2));
        CaptainsEntity cap = DataBase.getInstance().getCaptain(Integer.valueOf(data.get(3)));

        Integer avaliblePlaces = 0;
        if(ship.getShipLength() > 18) avaliblePlaces = port.getPlacesShipsBig() -
                getBookedPlacesNow(port, dateBegin).getValue() - getBookedPlacesBetween(port, dateBegin, dateEnd).getValue();
        else
            avaliblePlaces = port.getPlacesShipsSmall() -
                    getBookedPlacesNow(port, dateBegin).getKey() - getBookedPlacesBetween(port, dateBegin, dateEnd).getKey();
        if(avaliblePlaces == 0) return 6;

        VisitsEntity v = new VisitsEntity(dateBegin, dateEnd, port, user, ship, cap);
        DataBase.getInstance().addVisit(v);
        return 5;
    }

    private boolean captianInDataBase(String id){
        int i_id = Integer.valueOf(id);
        CaptainsEntity c = DataBase.getInstance().getCaptain(i_id);
        if(c == null) return false;
        return true;
    }

    public int addCaptian(Vector<String> data){
        for(int i =0; i < data.size(); i++){
            if(data.get(i).equals(""))
                return 0;
        }
        if(data.get(2).length() != 11) return 1;
        CaptainsEntity cap = new CaptainsEntity(data.get(0), data.get(1), data.get(2));
        DataBase.getInstance().addCaptain(cap);
        return 2;
    }

    public int addOwner(Vector<String> data){
        for(int i =0; i < data.size(); i++){
            if(data.get(i).equals(""))
                return 0;
        }
        if(data.get(1).length() != 9) return 1;
        if(!emailSuit(data.get(2))) return 2;
        if(!emailIsAvailable(data.get(2))) return 6;
        if(data.get(0).equals("private")) {
            if(data.get(5).length() != 11) return 3;
            ShipOwnersEntity owner = new ShipOwnersEntity(data.get(1), data.get(2), data.get(3),
                    data.get(4), data.get(5));
            DataBase.getInstance().addOwner(owner);
            return 5;
        }
        else{
            if(data.get(4).equals("commercial") && !data.get(4).chars().allMatch( Character::isDigit )) return 4;
            Integer n = Integer.valueOf(data.get(4));
            ShipOwnersEntity owner = new ShipOwnersEntity(data.get(2),
                    data.get(3), n, data.get(1));
            DataBase.getInstance().addOwner(owner);
            return 5;
        }
    }

    private boolean emailSuit(String email){
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if(mat.matches()) return true;
        return false;
    }

    private boolean emailIsAvailable(String email){
        ShipOwnersEntity owner = DataBase.getInstance().getOwnerByEmail(email);
        if(owner == null)  return true;
        return false;
    }

    public Pair<Integer, Integer> getBookedPlacesNow(PortsEntity port, Date date){
        Integer big = 0, small = 0;
        List<VisitsEntity>  visits = DataBase.getInstance().getVisitFromPort(port, date);
        for(VisitsEntity v: visits){
            if(v.getShipsEntity().getShipLength() > 18) big += 1;
            else small += 1;
        }
        Pair val = new Pair(small, big);
        return val;
    }

    public Pair<Integer, Integer> getBookedPlacesBetween(PortsEntity port, Date begin, Date end){
        List<VisitsEntity> visits = DataBase.getInstance().getVisitByPortBetween(port, begin, end);
        Integer small = 0;
        Integer big = 0;
        for(VisitsEntity v: visits){
            if(v.getShipsEntity().getShipLength() > 18) big += 1;
            else small+= 1;
        }
        Pair<Integer, Integer> v = new Pair<>(small, big);
        return v;
    }
}
