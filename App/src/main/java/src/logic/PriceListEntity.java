package src.logic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


/**
 * Class that is mapping Price_list entity to the class by the ORM conception
 */
@Entity
@Table(name = "PRICE_LIST")
public class PriceListEntity {
    @Id
    @SequenceGenerator(name = "price_list_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_list_id")
    @Column(name = "LIST_ID")
    private Integer listId;
    @Column(name = "LAUNDRY")
    private Short laundry;
    @Column(name = "DRYING_ROOM")
    private Short dryingRoom;
    @Column(name = "WATER")
    private Short water;
    @Column(name = "SHOWER")
    private Short shower;
    @Column(name = "SAUNA")
    private Short sauna;
    @Column(name = "PLACE_LESS_7M")
    private Short placeLess7M;
    @Column(name = "PLACE_7_12M")
    private Short place712M;
    @Column(name = "PLACE_12_17M")
    private Short place1217M;
    @Column(name = "PLACE_17_20M")
    private Short place1720M;
    @Column(name = "PLACE_MORE_20M")
    private Short placeMore20M;
    @OneToMany(mappedBy = "priceListEntity")
    private Collection<PortsEntity> portsEntities;

    public PriceListEntity()
    {}

    public PriceListEntity(int listId, Short laundry, Short dryingRoom, Short water, Short shower, Short sauna, Short placeLess7M,
                           Short place712M, Short place1217M, Short place1720M, Short placeMore20M) {
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

    public void addPort(PortsEntity port)
    {
        portsEntities.add(port);
    }

    public void removePort(PortsEntity port)
    {
        portsEntities.remove(port);
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public Short getLaundry() {
        return laundry;
    }

    public void setLaundry(Short laundry) {
        this.laundry = laundry;
    }

    public Short getDryingRoom() {
        return dryingRoom;
    }

    public void setDryingRoom(Short dryingRoom) {
        this.dryingRoom = dryingRoom;
    }

    public Short getWater() {
        return water;
    }

    public void setWater(Short water) {
        this.water = water;
    }

    public Short getShower() {
        return shower;
    }

    public void setShower(Short shower) {
        this.shower = shower;
    }

    public Short getSauna() {
        return sauna;
    }

    public void setSauna(Short sauna) {
        this.sauna = sauna;
    }

    public Short getPlaceLess7M() {
        return placeLess7M;
    }

    public void setPlaceLess7M(Short placeLess7M) {
        this.placeLess7M = placeLess7M;
    }

    public Short getPlace712M() {
        return place712M;
    }

    public void setPlace712M(Short place712M) {
        this.place712M = place712M;
    }

    public Short getPlace1217M() {
        return place1217M;
    }

    public void setPlace1217M(Short place1217M) {
        this.place1217M = place1217M;
    }

    public Short getPlace1720M() {
        return place1720M;
    }

    public void setPlace1720M(Short place1720M) {
        this.place1720M = place1720M;
    }

    public Short getPlaceMore20M() {
        return placeMore20M;
    }

    public void setPlaceMore20M(Short placeMore20M) {
        this.placeMore20M = placeMore20M;
    }

    public Collection<PortsEntity> getPortsEntities() {
        return portsEntities;
    }

    public void setPortsEntities(Collection<PortsEntity> portsEntities) {
        this.portsEntities = portsEntities;
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
