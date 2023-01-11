package src.logic;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AllUsersEntityTest {

    Date date = new Date(2002, 3, 16);
    Date emptyDate = new Date(0, 0, 0);
    AllUsersEntity myUser = new AllUsersEntity("jan123", "haslo123", "Jan", "Antecki", "511151118", date, "12345671829", "admin");
    AllUsersEntity emptyUser = new AllUsersEntity("", "", "", "", "", null, "", "");
    @Test
    void getLogin() {
        assertEquals("jan123", myUser.getLogin());
        assertNotEquals("", myUser.getLogin());
        assertEquals("", emptyUser.getLogin());
    }

    @Test
    void setLogin() {
        emptyUser.setLogin("Adam");
        assertEquals("Adam", emptyUser.getLogin());
    }

    @Test
    void getUserPassword() {
        assertEquals("haslo123", myUser.getUserPassword());
        assertNotEquals("", myUser.getUserPassword());
        assertEquals("", emptyUser.getUserPassword());
    }

    @Test
    void setUserPassword() {
        emptyUser.setUserPassword("qwerty");
        assertEquals("qwerty", emptyUser.getUserPassword());
    }

    @Test
    void getForename() {
        assertEquals("Jan", myUser.getForename());
        assertNotEquals("", myUser.getForename());
        assertEquals("", emptyUser.getForename());
    }

    @Test
    void setForename() {
        emptyUser.setForename("Maciej");
        assertEquals("Maciej", emptyUser.getForename());
    }

    @Test
    void getSurname() {
        assertEquals("Antecki", myUser.getSurname());
        assertNotEquals("", myUser.getSurname());
        assertEquals("", emptyUser.getSurname());
    }

    @Test
    void setSurname() {
        emptyUser.setSurname("Nowak");
        assertEquals("Nowak", emptyUser.getSurname());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("511151118", myUser.getPhoneNumber());
        assertNotEquals("", myUser.getPhoneNumber());
        assertEquals("", emptyUser.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        emptyUser.setPhoneNumber("111111111");
        assertEquals("111111111", emptyUser.getPhoneNumber());
    }

    @Test
    void getBirthday() {
        assertEquals(date, myUser.getBirthday());
        assertNotEquals(emptyDate, myUser.getBirthday());
        assertEquals(null, emptyUser.getBirthday());
    }

    @Test
    void setBirthday() {
        Date newDate = new Date(2022, 1, 13);
        emptyUser.setBirthday(newDate);
        assertEquals(newDate, emptyUser.getBirthday());
    }

    @Test
    void getPesel() {
        assertEquals("12345671829", myUser.getPesel());
        assertNotEquals("", myUser.getPesel());
        assertEquals("", emptyUser.getPesel());
    }

    @Test
    void setPesel() {
        emptyUser.setPesel("12312312399");
        assertEquals("12312312399", emptyUser.getPesel());
    }

    @Test
    void getUserType() {
        assertEquals("admin", myUser.getUserType());
        assertNotEquals("", myUser.getUserType());
        assertEquals("", emptyUser.getUserType());
    }

    @Test
    void setUserType() {
        emptyUser.setUserType("normal");
        assertEquals("normal", emptyUser.getUserType());
    }
}