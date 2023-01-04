package src.logic;

import jakarta.persistence.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PORTS")
public class PortsEntity {
    @Id
    @SequenceGenerator(name = "ports_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ports_id")
    @Column(name = "PORT_ID")
    private int portId;
    @Basic
    @Column(name = "PORT_NAME")
    private String portName;
    @Basic
    @Column(name = "PLACES_SHIPS_BIG")
    private int placesShipsBig;
    @Basic
    @Column(name = "PLACES_SHIPS_SMALL")
    private int placesShipsSmall;
    @Basic
    @Column(name = "STREET_NUMBER")
    private int streetNumber;
    @Basic
    @Column(name = "STREET_NAME")
    private String streetName;
    @Basic
    @Column(name = "CITY_NAME")
    private String cityName;
    @Basic
    @Column(name = "POST_CODE")
    private String postCode;
    @Basic
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "VHF_CHANNEL")
    private int vhfChannel;
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;

    @Column(name = "PRICE_LIST_ID")
    private int priceListId;

    public PortsEntity()
    {}

    public PortsEntity( String portName, int placesShipsBig, int placesShipsSmall, int streetNumber, String streetName, String cityName, String postCode, String phoneNumber, int vhfChannel, String bankAccount, int priceListId) {
//        this.portId = portId;
        this.portName = portName;
        this.placesShipsBig = placesShipsBig;
        this.placesShipsSmall = placesShipsSmall;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
        this.vhfChannel = vhfChannel;
        this.bankAccount = bankAccount;
        this.priceListId = priceListId;
    }
    @ManyToMany(mappedBy = "portsEntities")
    private Collection<AllUsersEntity> allUsersEntities;

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public int getPlacesShipsBig() {
        return placesShipsBig;
    }

    public void setPlacesShipsBig(int placesShipsBig) {
        this.placesShipsBig = placesShipsBig;
    }

    public int getPlacesShipsSmall() {
        return placesShipsSmall;
    }

    public void setPlacesShipsSmall(int placesShipsSmall) {
        this.placesShipsSmall = placesShipsSmall;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getVhfChannel() {
        return vhfChannel;
    }

    public void setVhfChannel(int vhfChannel) {
        this.vhfChannel = vhfChannel;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(int priceListId) {
        this.priceListId = priceListId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortsEntity that = (PortsEntity) o;
        return portId == that.portId && placesShipsBig == that.placesShipsBig && placesShipsSmall == that.placesShipsSmall && streetNumber == that.streetNumber && vhfChannel == that.vhfChannel && priceListId == that.priceListId && Objects.equals(portName, that.portName) && Objects.equals(streetName, that.streetName) && Objects.equals(cityName, that.cityName) && Objects.equals(postCode, that.postCode) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(bankAccount, that.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portId, portName, placesShipsBig, placesShipsSmall, streetNumber, streetName, cityName, postCode, phoneNumber, vhfChannel, bankAccount, priceListId);
    }

//    public Collection<AdminPortIntermediaryEntity> getAdminPortIntermediariesByPortId() {
//        return adminPortIntermediariesByPortId;
//    }
//
//    public void setAdminPortIntermediariesByPortId(Collection<AdminPortIntermediaryEntity> adminPortIntermediariesByPortId) {
//        this.adminPortIntermediariesByPortId = adminPortIntermediariesByPortId;
//    }
}
