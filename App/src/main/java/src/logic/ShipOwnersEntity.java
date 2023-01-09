package src.logic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "SHIP_OWNERS")
public class ShipOwnersEntity {
    @Id
    @SequenceGenerator(name = "ship_owners_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ship_owners_id")
    @Column(name = "SHIP_OWNER_ID")
    private Integer shipOwnerId;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FORENAME")
    private String forname;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "PESEL")
    private String pesel;
    @Column(name = "NAME_COMPANY")
    private String nameCompany;
    @Column(name = "NIP")
    private Integer nip;

    @OneToMany(mappedBy = "shipOwnersEntity")
    private Collection<ShipsEntity> shipsEntities;

    public ShipOwnersEntity(String phoneNumber, String email, String forename,
                            String surname, String pesel, Collection<ShipsEntity> shipsEntities) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.forname = forename;
        this.surname = surname;
        this.pesel = pesel;
        this.shipsEntities = shipsEntities;
    }

    public ShipOwnersEntity(String phoneNumber, String email, String forename,
                            String surname, String pesel) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.forname = forename;
        this.surname = surname;
        this.pesel = pesel;
    }

    public ShipOwnersEntity(String email, String nameCompany, Integer nip, String phoneNumber) {
        this.email = email;
        this.nameCompany = nameCompany;
        this.nip = nip;
        this.shipsEntities = new ArrayList<>();
        this.phoneNumber = phoneNumber;
    }

    public ShipOwnersEntity() {
    }

    public void addShip(ShipsEntity ship){
        this.shipsEntities.add(ship);
    }

    public Collection<ShipsEntity> getShipsEntities() {
        return shipsEntities;
    }

    public void setShipsEntities(Collection<ShipsEntity> shipsEntities) {
        this.shipsEntities = shipsEntities;
    }

    public Integer getShipOwnerId() {
        return shipOwnerId;
    }

    public void setShipOwnerId(Integer shipOwnerId) {
        this.shipOwnerId = shipOwnerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Integer getNip() {
        return nip;
    }

    public void setNip(Integer nip) {
        this.nip = nip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipOwnersEntity that = (ShipOwnersEntity) o;
        return shipOwnerId == that.shipOwnerId && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email) && Objects.equals(forname, that.forname) && Objects.equals(surname, that.surname) && Objects.equals(pesel, that.pesel) && Objects.equals(nameCompany, that.nameCompany) && Objects.equals(nip, that.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipOwnerId, phoneNumber, email, forname, surname, pesel, nameCompany, nip);
    }
}
