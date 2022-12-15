package src.appActions;

import src.logic.*;
import src.app.DataBase;

import java.util.Vector;

public class getData {
    AllUsersEntity login(String login, String password){
        AllUsersEntity currentUser = DataBase.getInstance().getUser(login);
        if(currentUser.getUserPassword().equals(password)){
            return currentUser;
        }
        return null;
    }

    PortsEntity getPort(String portId){
        PortsEntity chosedPort = DataBase.getInstance().getPort(portId);
        return chosedPort;
    }
}
