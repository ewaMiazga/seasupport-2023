package src.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ADMIN_PORT_INTERMEDIARY")
@IdClass(AdminPortIntermediaryEntityPK.class)
public class AdminPortIntermediaryEntity {
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Id
    @Column(name = "PORT_ID")
    private int portId;
    @ManyToOne
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN", nullable = false)
    private AllUsersEntity allUsersByLogin;

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
        AdminPortIntermediaryEntity that = (AdminPortIntermediaryEntity) o;
        return portId == that.portId && Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, portId);
    }

    public AllUsersEntity getAllUsersByLogin() {
        return allUsersByLogin;
    }

    public void setAllUsersByLogin(AllUsersEntity allUsersByLogin) {
        this.allUsersByLogin = allUsersByLogin;
    }
}
