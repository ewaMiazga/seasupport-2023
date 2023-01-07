package src.appActions;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.chart.PieChart;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.dialect.DatabaseVersion;
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
        int owner_id = Integer.valueOf(data.get(4));
        short len = Short.valueOf(data.get(3));
        ShipsEntity ship = new ShipsEntity(data.get(0), data.get(1), data.get(2), len, owner);
        DataBase.getInstance().addShip(ship);
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
        Date dateBegin = Date.valueOf(begin);
        Date dateEnd = Date.valueOf(end);
        for(int i =0; i < data.size(); i++){
            if(data.get(i).equals(""))
                return 0;
        }
        if(data.get(2).length() != 11) return 1;
        if(begin.isBefore(LocalDate.now())) return 2;
        if(begin.isAfter(end)) return 3;
        if(!shipInDataBase(data.get(5))) return 4;
        ShipsEntity ship = DataBase.getInstance().getShip(data.get(5));
        if(checkAvalivblePlaces(ship.getShipLength(), port, dateBegin, dateEnd) == 0) return 6;
        //VisitsEntity v = new VisitsEntity(dateBegin, dateEnd, port.getPortId(), user.getLogin(), ship.getCallSign(),
        //        ship.)
        return 5;
    }

    public int checkAvalivblePlaces(short ShipLen, PortsEntity port, Date dateBegin, Date dateEnd){
        int len = 15;
        int portPlaces = port.getPlacesShipsSmall();
        if (ShipLen > len){
            len = 30;
            portPlaces = port.getPlacesShipsBig();
        }
        int places = 0;
        List<VisitsEntity> visits = DataBase.getInstance().getVisitFromPort(port, dateBegin, dateEnd);
        ShipsEntity currentShip = new ShipsEntity();
        for(VisitsEntity v : visits){
            currentShip = DataBase.getInstance().getShip(v.getShipsEntity().getCallSign());
            if(currentShip.getShipLength() <= len && currentShip.getShipLength() >= len - 15) places++;
        }
        return(portPlaces - places);
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
        CaptainsEntity cap = new CaptainsEntity(data.get(0), data.get(1), data.get(2), 1);
        DataBase.getInstance().addCaptain(cap);
        return 2;
    }

    public int addOwner(Vector<String> data){
        int size = data.size();
        if(data.get(5).equals("Private")) {
            size -= 2;
            for(int i =0; i < size; i++){
                if(data.get(i).equals(""))
                    return 0;
            }
            if(data.get(2).length() != 9) return 1;
            if(!emailSuit(data.get(3))) return 2;
            if(data.get(4).length() != 11) return 3;
            ShipOwnersEntity owner = new ShipOwnersEntity(data.get(2), data.get(3),
                    data.get(0), data.get(1), data.get(4));
            DataBase.getInstance().addOwner(owner);
            return 5;
        }
        else{
            for(int i =2; i < size; i++){
                if(data.get(i).equals(""))
                    return 0;
            }
            if(data.get(2).length() != 9) return 1;
            if(!emailSuit(data.get(3))) return 2;
            if(data.get(4).length() != 11) return 3;
            if(data.get(5).equals("Comercial") && !data.get(7).chars().allMatch( Character::isDigit )) return 4;
            Integer n = Integer.valueOf(data.get(7));
            ShipOwnersEntity owner = new ShipOwnersEntity(data.get(3),
                    data.get(6), n, data.get(2));
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

}
