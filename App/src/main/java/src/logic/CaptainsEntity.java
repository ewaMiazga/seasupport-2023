package src.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CAPTAINS")
public class CaptainsEntity {
    @Column(name = "FORENAME")
    private String forename;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "PESEL")
    private String pesel;
    @Id
    @SequenceGenerator(name = "captains_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "captains_id")
    @Column(name = "CAPTAIN_ID")
    private int captainId;
    @OneToMany(mappedBy = "captainsEntity")
    private Collection<VisitsEntity>  visitsEntity;

    public CaptainsEntity()
    {}

    public CaptainsEntity(String forename, String surname, String pesel, int captainId, Collection<VisitsEntity> visitsEntity) {
        this.forename = forename;
        this.surname = surname;
        this.pesel = pesel;
        this.captainId = captainId;
        this.visitsEntity = visitsEntity;
    }

    public Collection<VisitsEntity> getVisitsEntity() {
        return visitsEntity;
    }

    public void setVisitsEntity(Collection<VisitsEntity> visitsEntity) {
        this.visitsEntity = visitsEntity;
    }

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
