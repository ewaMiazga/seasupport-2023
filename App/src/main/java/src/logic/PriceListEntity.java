package src.logic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PRICE_LIST")
public class PriceListEntity {
    @Id
    @Column(name = "LIST_ID")
    private int listId;
    @Column(name = "LAUNDRY")
    private Byte laundry;
    @Column(name = "DRYING_ROOM")
    private Byte dryingRoom;
    @Column(name = "WATER")
    private Byte water;
    @Column(name = "SHOWER")
    private Byte shower;
    @Column(name = "SAUNA")
    private Byte sauna;
    @Column(name = "PLACE_LESS_7M")
    private short placeLess7M;
    @Column(name = "PLACE_7_12M")
    private short place712M;
    @Column(name = "PLACE_12_17M")
    private short place1217M;
    @Column(name = "PLACE_17_20M")
    private short place1720M;
    @Column(name = "PLACE_MORE_20M")
    private short placeMore20M;
    @OneToMany(mappedBy = "priceListEntity")
    private Collection<PortsEntity> portsEntities;

    public PriceListEntity(int listId, Byte laundry, Byte dryingRoom, Byte water, Byte shower, Byte sauna, short placeLess7M,
                           short place712M, short place1217M, short place1720M, short placeMore20M) {
        this.listId = listId;
        this.laundry = laundry;
        this.dryingRoom = dryingRoom;
        this.water = water;
        this.shower = shower;
        this.sauna = sauna;
        this.placeLess7M = placeLess7M;
        this.place712M = place712M;
        this.place1217M = place1217M;
        this.place1720M = place1720M;
        this.placeMore20M = placeMore20M;
        this.portsEntities = new ArrayList<PortsEntity>();
    }

    public PriceListEntity(int listId, short placeLess7M, short place712M, short place1217M, short place1720M,
                           short placeMore20M) {
        this.listId = listId;
        this.placeLess7M = placeLess7M;
        this.place712M = place712M;
        this.place1217M = place1217M;
        this.place1720M = place1720M;
        this.placeMore20M = placeMore20M;
        this.portsEntities = new ArrayList<PortsEntity>();
    }

    public void addPort(PortsEntity port){
        this.portsEntities.add(port);
    }

    public PriceListEntity() {
    }

    public Collection<PortsEntity> getPortsEntities() {
        return portsEntities;
    }

    public void setPortsEntities(Collection<PortsEntity> portsEntities) {
        this.portsEntities = portsEntities;
    }

    public int getListId() {
        return listId;
    }

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

}
