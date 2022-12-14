package src.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PRICE_LIST")
public class PriceListEntity {
    @Id
    @Column(name = "LIST_ID")
    private int listId;
    @Basic
    @Column(name = "LAUNDRY")
    private Byte laundry;
    @Basic
    @Column(name = "DRYING_ROOM")
    private Byte dryingRoom;
    @Basic
    @Column(name = "WATER")
    private Byte water;
    @Basic
    @Column(name = "SHOWER")
    private Byte shower;
    @Basic
    @Column(name = "SAUNA")
    private Byte sauna;
    @Basic
    @Column(name = "PLACE_LESS_7M")
    private short placeLess7M;
    @Basic
    @Column(name = "PLACE_7_12M")
    private short place712M;
    @Basic
    @Column(name = "PLACE_12_17M")
    private short place1217M;
    @Basic
    @Column(name = "PLACE_17_20M")
    private short place1720M;
    @Basic
    @Column(name = "PLACE_MORE_20M")
    private short placeMore20M;
    @OneToMany(mappedBy = "priceListByPriceListId")
    private Collection<PortsEntity> portsByListId;

    public int getListId() { return listId; }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public Byte getLaundry() {
        return laundry;
    }

    public void setLaundry(Byte laundry) {
        this.laundry = laundry;
    }

    public Byte getDryingRoom() {
        return dryingRoom;
    }

    public void setDryingRoom(Byte dryingRoom) {
        this.dryingRoom = dryingRoom;
    }

    public Byte getWater() {
        return water;
    }

    public void setWater(Byte water) {
        this.water = water;
    }

    public Byte getShower() {
        return shower;
    }

    public void setShower(Byte shower) {
        this.shower = shower;
    }

    public Byte getSauna() {
        return sauna;
    }

    public void setSauna(Byte sauna) {
        this.sauna = sauna;
    }

    public short getPlaceLess7M() {
        return placeLess7M;
    }

    public void setPlaceLess7M(short placeLess7M) {
        this.placeLess7M = placeLess7M;
    }

    public short getPlace712M() {
        return place712M;
    }

    public void setPlace712M(short place712M) {
        this.place712M = place712M;
    }

    public short getPlace1217M() {
        return place1217M;
    }

    public void setPlace1217M(short place1217M) {
        this.place1217M = place1217M;
    }

    public short getPlace1720M() {
        return place1720M;
    }

    public void setPlace1720M(short place1720M) {
        this.place1720M = place1720M;
    }

    public short getPlaceMore20M() {
        return placeMore20M;
    }

    public void setPlaceMore20M(short placeMore20M) {
        this.placeMore20M = placeMore20M;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceListEntity that = (PriceListEntity) o;
        return listId == that.listId && placeLess7M == that.placeLess7M && place712M == that.place712M && place1217M == that.place1217M && place1720M == that.place1720M && placeMore20M == that.placeMore20M && Objects.equals(laundry, that.laundry) && Objects.equals(dryingRoom, that.dryingRoom) && Objects.equals(water, that.water) && Objects.equals(shower, that.shower) && Objects.equals(sauna, that.sauna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId, laundry, dryingRoom, water, shower, sauna, placeLess7M, place712M, place1217M, place1720M, placeMore20M);
    }

    public Collection<PortsEntity> getPortsByListId() {
        return portsByListId;
    }

    public void setPortsByListId(Collection<PortsEntity> portsByListId) {
        this.portsByListId = portsByListId;
    }
}
