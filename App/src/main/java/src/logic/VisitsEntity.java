package src.logic;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VISITS")
public class VisitsEntity {

    @Column(name = "DATE_BEGIN")
    private Date dateBegin;
    @Column(name = "DATE_END")
    private Date dateEnd;
    @Id
    @SequenceGenerator(name = "visit_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visit_id")
    @Column(name = "VISIT_ID")
    private int visitId;
    @ManyToOne
    @JoinColumn(name = "PORT_ID", referencedColumnName = "PORT_ID")
    private PortsEntity portsEntity;
    @ManyToOne
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN")
    private AllUsersEntity allUsersEntity;
    @ManyToOne
    @JoinColumn(name = "CALL_SIGN", referencedColumnName = "CALL_SIGN")
    private ShipsEntity shipsEntity;
    @ManyToOne
    @JoinColumn(name = "CAPTAIN_ID", referencedColumnName = "CAPTAIN_ID")
    private CaptainsEntity captainsEntity;

    public VisitsEntity(Date dateBegin, int portId, String login, String callSign, int captainId, int visitId, PortsEntity portsEntity, AllUsersEntity allUsersEntity, ShipsEntity shipsEntity, CaptainsEntity captainsEntity) {
        this.dateBegin = dateBegin;
        this.visitId = visitId;
        this.portsEntity = portsEntity;
        this.allUsersEntity = allUsersEntity;
        this.shipsEntity = shipsEntity;
        this.captainsEntity = captainsEntity;
    }

    public VisitsEntity() {
    }

    public PortsEntity getPortsEntity() {
        return portsEntity;
    }

    public void setPortsEntity(PortsEntity portsEntity) {
        this.portsEntity = portsEntity;
    }

    public AllUsersEntity getAllUsersEntity() {
        return allUsersEntity;
    }

    public void setAllUsersEntity(AllUsersEntity allUsersEntity) {
        this.allUsersEntity = allUsersEntity;
    }

    public ShipsEntity getShipsEntity() {
        return shipsEntity;
    }

    public void setShipsEntity(ShipsEntity shipsEntity) {
        this.shipsEntity = shipsEntity;
    }

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
        return visitId == that.visitId && Objects.equals(dateBegin, that.dateBegin) && Objects.equals(dateEnd, that.dateEnd) && Objects.equals(portsEntity, that.portsEntity) && Objects.equals(allUsersEntity, that.allUsersEntity) && Objects.equals(shipsEntity, that.shipsEntity) && Objects.equals(captainsEntity, that.captainsEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateBegin, dateEnd, visitId, portsEntity, allUsersEntity, shipsEntity, captainsEntity);
    }

    public CaptainsEntity getCaptainsEntity() {
        return captainsEntity;
    }

    public void setCaptainsEntity(CaptainsEntity captainsEntity) {
        this.captainsEntity = captainsEntity;
    }



}
