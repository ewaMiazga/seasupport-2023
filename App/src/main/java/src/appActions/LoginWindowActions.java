package src.appActions;

import src.logic.*;
import src.app.DataBase;

import java.sql.Date;

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

    public AllUsersEntity register(String login, String password, String name, String surname,
    String phone, Date birthDate, String pesel, String userType){
        if(loginIsAvalible(login)){
            AllUsersEntity newUser = new AllUsersEntity(login, password, name, surname, phone, birthDate, pesel, userType);
            DataBase.getInstance().addUser(newUser);
            return newUser;
        }
        return null;
    }

    public boolean loginIsAvalible(String login){
        AllUsersEntity currentUser = DataBase.getInstance().getUser(login);
        if(currentUser != null)
            return false;
        return true;
    }
}
