package src.appActions;

import src.logic.*;
import src.app.DataBase;

import java.text.ParseException;
import java.util.Vector;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class LoginWindowActions {
    public AllUsersEntity login(String login, String password){
        AllUsersEntity currentUser = DataBase.getInstance().getUser(login);
        if(currentUser != null){
            if(currentUser.getUserPassword().equals(password)) {
                return currentUser;
            }
        }
        return null;
    }

    public AllUsersEntity register(Vector<String> data){
        String login = data.get(0);
        String password = data.get(1);
        String name = data.get(4);
        String surname = data.get(5);
        String phone = data.get(6);
        Date birthDate = convertToDate(data.get(8));
        String pesel = data.get(7);
        String userType = data.get(3);
        if(loginIsAvalible(login)){
            AllUsersEntity newUser = new AllUsersEntity(login, password, name, surname, phone, birthDate, pesel, userType);
            DataBase.getInstance().addUser(newUser);
            return newUser;
        }
        return null;
    }

    public Date convertToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = (Date) formatter.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int checkRegData(Vector<String> data){
        if(!loginIsAvalible(data.get(0))) return 0;
        if(!data.get(1).equals(data.get(2))) return 1;
        // sprawdzenie user czy dobry typ, trzeba ustalic jaki ma byc format.
        if(data.get(6).length() != 9) return 2;
        if(data.get(7).length() != 11) return 3;
        // sprawdzenie daty.
        return 6;
    }

    public boolean loginIsAvalible(String login){
        AllUsersEntity currentUser = DataBase.getInstance().getUser(login);
        if(currentUser != null)
            return false;
        return true;
    }
}
