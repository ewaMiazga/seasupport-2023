package src.logic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


/**
 * Class that is mapping Ships entity to the class by the ORM conception
 */
@Entity
@Table(name = "SHIPS")
public class ShipsEntity {
    @Id
    @Column(name = "CALL_SIGN")
    private String callSign;
    @Column(name = "SHIP_NAME")
    private String shipName;
    @Column(name = "SHIP_TYPE")
    private String shipType;
    @Column(name = "SHIP_LENGTH")
    private Short shipLength;
    @ManyToOne
    @JoinColumn(name = "SHIP_OWNER_ID", referencedColumnName = "SHIP_OWNER_ID")
    private ShipOwnersEntity shipOwnersEntity;
    @OneToMany(mappedBy = "shipsEntity", fetch = FetchType.EAGER)
    private Collection<VisitsEntity> visitsEntities;

    public ShipsEntity(String callSign, String shipName, String shipType, short shipLength, ShipOwnersEntity shipOwnersEntity) {
        this.callSign = callSign;
        this.shipName = shipName;
        this.shipType = shipType;
        this.shipLength = shipLength;
        this.shipOwnersEntity = shipOwnersEntity;
        this.visitsEntities = new ArrayList<VisitsEntity>();
    }

    public ShipsEntity() {
    }


    public void addVisit(VisitsEntity visit)
    {
        this.visitsEntities.add(visit);
    }

    public Collection<VisitsEntity> getVisitsEntities() {
        return visitsEntities;
    }

    public void setVisitsEntities(Collection<VisitsEntity> visitsEntities) {
        this.visitsEntities = visitsEntities;
    }


    public ShipsEntity(String callSign, String shpipName, int shipOwnerId, String shipType, short shipLength, ShipOwnersEntity shipOwnersByShipOwnerId) {
        this.callSign = callSign;
        this.shipName = shpipName;
        this.shipType = shipType;
        this.shipLength = shipLength;
        this.shipOwnersEntity = shipOwnersByShipOwnerId;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shpipName) {
        this.shipName = shpipName;
    }




    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public short getShipLength() {
        return shipLength;
    }

    public void setShipLength(short shipLength) {
        this.shipLength = shipLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipsEntity that = (ShipsEntity) o;
        return shipLength == that.shipLength && Objects.equals(callSign, that.callSign) && Objects.equals(shipName, that.shipName) && Objects.equals(shipType, that.shipType) && Objects.equals(shipOwnersEntity, that.shipOwnersEntity) && Objects.equals(visitsEntities, that.visitsEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callSign, shipName, shipType, shipLength, shipOwnersEntity, visitsEntities);
    }

    public ShipOwnersEntity getShipOwnersEntity() {
        return shipOwnersEntity;
    }

    public void setShipOwnersEntity(ShipOwnersEntity shipOwnersEntity) {
        this.shipOwnersEntity = shipOwnersEntity;
    }
}
