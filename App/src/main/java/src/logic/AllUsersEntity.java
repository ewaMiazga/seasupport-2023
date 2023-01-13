package src.logic;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


/**
 * Class that is mapping All_Users entity to the class by the ORM conception
 */
@Entity
@Table(name = "ALL_USERS")
public class AllUsersEntity {
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Basic
    @Column(name = "FORENAME")
    private String forename;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "PESEL")
    private String pesel;
    @Column(name = "USER_TYPE")
    private String userType;

    public AllUsersEntity()
    {}

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ADMIN_PORT_INTERMEDIARY",
            joinColumns = { @JoinColumn(name = "LOGIN") },
            inverseJoinColumns = { @JoinColumn(name = "PORT_ID") }
    )
    private Collection<PortsEntity> portsEntities;

    @OneToMany(mappedBy = "allUsersEntity", fetch = FetchType.EAGER)
    private Collection<VisitsEntity> visitsEntities;

    public AllUsersEntity(String login, String userPassword, String forename, String surname, String phoneNumber, Date birthday, String pesel, String userType) {
        this.login = login;
        this.userPassword = userPassword;
        this.forename = forename;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.pesel = pesel;
        this.userType = userType;
        this.portsEntities = new ArrayList<PortsEntity>();
        this.visitsEntities = new ArrayList<VisitsEntity>();
    }

    public AllUsersEntity(String login, String userPassword, String forename, String surname, String phoneNumber, Date birthday, String userType) {
        this.login = login;
        this.userPassword = userPassword;
        this.forename = forename;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.userType = userType;
        this.portsEntities = new ArrayList<PortsEntity>();
        this.visitsEntities = new ArrayList<VisitsEntity>();
    }

    public Collection<PortsEntity> getPortsEntities() {
        return portsEntities;
    }

    public void setPortsEntities(Collection<PortsEntity> portsEntities) {
        this.portsEntities = portsEntities;
    }

    public Collection<VisitsEntity> getVisitsEntities() {
        return visitsEntities;
    }

    public void setVisitsEntities(Collection<VisitsEntity> visitsEntities) {
        this.visitsEntities = visitsEntities;
    }
    public void addPort(PortsEntity port)
    {
        this.portsEntities.add(port);
    }
    public void addVisit(VisitsEntity visit)
    {
        this.visitsEntities.add(visit);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllUsersEntity that = (AllUsersEntity) o;
        return Objects.equals(login, that.login) && Objects.equals(userPassword, that.userPassword) && Objects.equals(forename, that.forename) && Objects.equals(surname, that.surname) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(birthday, that.birthday) && Objects.equals(pesel, that.pesel) && Objects.equals(userType, that.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, userPassword, forename, surname, phoneNumber, birthday, pesel, userType);
    }
}
