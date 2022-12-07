package src.logic;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


public class AdminPortIntermediaryEntityPK implements Serializable {
    @Column(name = "LOGIN")
    @Id
    private String login;
    @Column(name = "PORT_ID")
    @Id
    private int portId;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminPortIntermediaryEntityPK that = (AdminPortIntermediaryEntityPK) o;
        return portId == that.portId && Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, portId);
    }
}
