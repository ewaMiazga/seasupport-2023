package src.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PORTS")
public class PortsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PORT_ID")
    private int portId;
    @Basic
    @Column(name = "PORT_NAME")
    private String portName;
    @Basic
    @Column(name = "PLACES_SHIPS_BIG")
    private byte placesShipsBig;
    @Basic
    @Column(name = "PLACES_SHIPS_SMALL")
    private byte placesShipsSmall;
    @Basic
    @Column(name = "STREET_NUMBER")
    private byte streetNumber;
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
    @Basic
    @Column(name = "VHF_CHANNEL")
    private byte vhfChannel;
    @Basic
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    @Basic
    @Column(name = "PRICE_LIST_ID")
    private int priceListId;
    @OneToMany(mappedBy = "portsByPortId")
    private Collection<AdminPortIntermediaryEntity> adminPortIntermediariesByPortId;

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

    public byte getPlacesShipsBig() {
        return placesShipsBig;
    }

    public void setPlacesShipsBig(byte placesShipsBig) {
        this.placesShipsBig = placesShipsBig;
    }

    public byte getPlacesShipsSmall() {
        return placesShipsSmall;
    }

    public void setPlacesShipsSmall(byte placesShipsSmall) {
        this.placesShipsSmall = placesShipsSmall;
    }

    public byte getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(byte streetNumber) {
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

    public byte getVhfChannel() {
        return vhfChannel;
    }

    public void setVhfChannel(byte vhfChannel) {
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

    public Collection<AdminPortIntermediaryEntity> getAdminPortIntermediariesByPortId() {
        return adminPortIntermediariesByPortId;
    }

    public void setAdminPortIntermediariesByPortId(Collection<AdminPortIntermediaryEntity> adminPortIntermediariesByPortId) {
        this.adminPortIntermediariesByPortId = adminPortIntermediariesByPortId;
    }

    public boolean isAvalible(int shipLen){
        if(shipLen <= 15){
            this.placesShipsSmall -= 1;
            return true;
        }
        if(shipLen <= 30){
            this.placesShipsBig -= 1;
            return true;
        }
        return false;
    }
}
