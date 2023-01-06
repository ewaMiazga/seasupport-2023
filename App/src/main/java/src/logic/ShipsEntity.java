package src.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "SHIPS")
public class ShipsEntity {
    @Id
    @Column(name = "CALL_SIGN")
    private String callSign;
    @Basic
    @Column(name = "SHPIP_NAME")
    private String shpipName;
    @Basic
    @Column(name = "SHIP_OWNER_ID")
    private int shipOwnerId;
    @Basic
    @Column(name = "SHIP_TYPE")
    private String shipType;
    @Basic
    @Column(name = "SHIP_LENGTH")
    private short shipLength;
    @ManyToOne
    @JoinColumn(name = "SHIP_OWNER_ID", referencedColumnName = "SHIP_OWNER_ID", nullable = false)
    private ShipOwnersEntity shipOwnersByShipOwnerId;

    public ShipsEntity(){

    }

    public ShipsEntity(String callSign, String shpipName, int shipOwnerId, String shipType, short shipLength, ShipOwnersEntity shipOwnersByShipOwnerId) {
        this.callSign = callSign;
        this.shpipName = shpipName;
        this.shipOwnerId = shipOwnerId;
        this.shipType = shipType;
        this.shipLength = shipLength;
        this.shipOwnersByShipOwnerId = shipOwnersByShipOwnerId;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getShpipName() {
        return shpipName;
    }

    public void setShpipName(String shpipName) {
        this.shpipName = shpipName;
    }

    public int getShipOwnerId() {
        return shipOwnerId;
    }

    public void setShipOwnerId(int shipOwnerId) {
        this.shipOwnerId = shipOwnerId;
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
        return shipOwnerId == that.shipOwnerId && shipLength == that.shipLength && Objects.equals(callSign, that.callSign) && Objects.equals(shpipName, that.shpipName) && Objects.equals(shipType, that.shipType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callSign, shpipName, shipOwnerId, shipType, shipLength);
    }

    public ShipOwnersEntity getShipOwnersByShipOwnerId() {
        return shipOwnersByShipOwnerId;
    }

    public void setShipOwnersByShipOwnerId(ShipOwnersEntity shipOwnersByShipOwnerId) {
        this.shipOwnersByShipOwnerId = shipOwnersByShipOwnerId;
    }
}
