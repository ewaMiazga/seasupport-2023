package src.appActions;

import src.logic.AllUsersEntity;
import src.logic.*;
import java.util.ArrayList;
import java.util.List;

public class AppGetData{
    public AllUsersEntity login(String login, String password){
        try{
            // AllUsersEntity current_user = get user from database(login, password)
            if(password.equals(currnet_user.getUserPassword())) {
                return current_user;
            }
        }
        catch (Exception e){
            return null;
        }
    }

    public void updateUser(AllUsersEntity current_user)
    {
        //wywolanie funkcji Michala
    }

    public List getPorts(){
        //List ports = pobierz liste portow
        //return ports;
    }

    public boolean loginIsAvalible(String login) {
        //if(funkcja sprawdzajca czy login jest w bazie){
        // return false;
        //}
        // return true;
    }

    public void createUser(String login, String userPassword, String forename,
                           String surname, String phoneNumber, Date birthday, String pesel,
                           String userType){
        if(loginIsAvalible(login)){
            AllUsersEntity new_user = new AllUsersEntity(String login, String userPassword, String forename,
                    String surname, String phoneNumber, Date birthday, String pesel,
                    String userType);
            updateUser(new_user);
        }
    }
}
