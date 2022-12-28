package src.logic;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

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
    public AllUsersEntity(String login, String userPassword, String forename, String surname, String phoneNumber, Date birthday, String pesel, String userType) {
        this.login = login;
        this.userPassword = userPassword;
        this.forename = forename;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.pesel = pesel;
        this.userType = userType;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "ADMIN_PORT_INTERMEDIARY",
            joinColumns = { @JoinColumn(name = "LOGIN") },
            inverseJoinColumns = { @JoinColumn(name = "PORT_ID") }
    )
    private Collection<PortsEntity> portsEntities;

    @OneToMany(mappedBy = "allUsersEntity")
    private Collection<VisitsEntity> visitsEntities;

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
