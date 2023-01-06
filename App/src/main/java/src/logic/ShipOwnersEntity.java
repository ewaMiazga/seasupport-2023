package src.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "SHIP_OWNERS")
public class ShipOwnersEntity {
    public ShipOwnersEntity(int shipOwnerId, String phoneNumber, String email, String forname,
                            String surname, String pesel, String nameCompany, Integer nip) {
        this.shipOwnerId = shipOwnerId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.forname = forname;
        this.surname = surname;
        this.pesel = pesel;
        this.nameCompany = nameCompany;
        this.nip = nip;
    }

    @Id
    @Column(name = "SHIP_OWNER_ID")
    private int shipOwnerId;
    @Basic
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "FORNAME")
    private String forname;
    @Basic
    @Column(name = "SURNAME")
    private String surname;
    @Basic
    @Column(name = "PESEL")
    private String pesel;
    @Basic
    @Column(name = "NAME_COMPANY")
    private String nameCompany;
    @Basic
    @Column(name = "NIP")
    private Integer nip;

    public int getShipOwnerId() {
        return shipOwnerId;
    }

    public void setShipOwnerId(int shipOwnerId) {
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
