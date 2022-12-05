package src.logic;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VISITS")
public class VisitsEntity {
    @Basic
    @Column(name = "DATE_BEGIN")
    private Date dateBegin;
    @Basic
    @Column(name = "DATE_END")
    private Date dateEnd;
    @Basic
    @Column(name = "PORT_ID")
    private int portId;
    @Basic
    @Column(name = "LOGIN")
    private String login;
    @Basic
    @Column(name = "CALL_SIGN")
    private String callSign;
    @Basic
    @Column(name = "CAPTAIN_ID")
    private int captainId;
    @Id
    @Column(name = "VISIT_ID")
    private int visitId;
    @ManyToOne
    @JoinColumn(name = "PORT_ID", referencedColumnName = "PORT_ID", nullable = false)
    private PortsEntity portsByPortId;
    @ManyToOne
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN", nullable = false)
    private AllUsersEntity allUsersByLogin;
    @ManyToOne
    @JoinColumn(name = "CALL_SIGN", referencedColumnName = "CALL_SIGN", nullable = false)
    private ShipsEntity shipsByCallSign;
    @ManyToOne
    @JoinColumn(name = "CAPTAIN_ID", referencedColumnName = "CAPTAIN_ID", nullable = false)
    private CaptainsEntity captainsByCaptainId;

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public int getCaptainId() {
        return captainId;
    }

    public void setCaptainId(int captainId) {
        this.captainId = captainId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitsEntity that = (VisitsEntity) o;
        return portId == that.portId && captainId == that.captainId && visitId == that.visitId && Objects.equals(dateBegin, that.dateBegin) && Objects.equals(dateEnd, that.dateEnd) && Objects.equals(login, that.login) && Objects.equals(callSign, that.callSign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateBegin, dateEnd, portId, login, callSign, captainId, visitId);
    }

    public PortsEntity getPortsByPortId() {
        return portsByPortId;
    }

    public void setPortsByPortId(PortsEntity portsByPortId) {
        this.portsByPortId = portsByPortId;
    }

    public AllUsersEntity getAllUsersByLogin() {
        return allUsersByLogin;
    }

    public void setAllUsersByLogin(AllUsersEntity allUsersByLogin) {
        this.allUsersByLogin = allUsersByLogin;
    }

    public ShipsEntity getShipsByCallSign() {
        return shipsByCallSign;
    }

    public void setShipsByCallSign(ShipsEntity shipsByCallSign) {
        this.shipsByCallSign = shipsByCallSign;
    }

    public CaptainsEntity getCaptainsByCaptainId() {
        return captainsByCaptainId;
    }

    public void setCaptainsByCaptainId(CaptainsEntity captainsByCaptainId) {
        this.captainsByCaptainId = captainsByCaptainId;
    }
}
