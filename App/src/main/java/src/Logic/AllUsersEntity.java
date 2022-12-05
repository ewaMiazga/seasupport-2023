package src.logic;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ALL_USERS")
public class AllUsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Basic
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Basic
    @Column(name = "FORENAME")
    private String forename;
    @Basic
    @Column(name = "SURNAME")
    private String surname;
    @Basic
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Basic
    @Column(name = "PESEL")
    private String pesel;
    @Basic
    @Column(name = "USER_TYPE")
    private String userType;

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
