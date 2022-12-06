package src.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CAPTAINS")
public class CaptainsEntity {
    @Basic
    @Column(name = "FORENAME")
    private String forename;
    @Basic
    @Column(name = "SURNAME")
    private String surname;
    @Basic
    @Column(name = "PESEL")
    private String pesel;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CAPTAIN_ID")
    private int captainId;

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
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

    public int getCaptainId() {
        return captainId;
    }

    public void setCaptainId(int captainId) {
        this.captainId = captainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaptainsEntity that = (CaptainsEntity) o;
        return captainId == that.captainId && Objects.equals(forename, that.forename) && Objects.equals(surname, that.surname) && Objects.equals(pesel, that.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forename, surname, pesel, captainId);
    }
}
