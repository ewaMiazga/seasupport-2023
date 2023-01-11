package src.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class ShipOwnersEntityTest {

    ShipOwnersEntity Owner = new ShipOwnersEntity("nowak@gmail.com", "Podróżnicy", 12345, "519259223");

    ShipOwnersEntity Owner2 = new ShipOwnersEntity("123456789", "antek@gmail.com", "jan", "antecki", "01010101");

    ShipOwnersEntity Empty = new ShipOwnersEntity("", "", "", "", "");


    @Test
    void setShipOwnerId() {
        Owner.setShipOwnerId(1);
        Owner2.setShipOwnerId(9999);
        Empty.setShipOwnerId(-123);
        assertEquals(1, Owner.getShipOwnerId());
        assertEquals(9999, Owner2.getShipOwnerId());
        assertEquals(-123, Empty.getShipOwnerId());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("123456789", Owner2.getPhoneNumber());
        assertEquals("519259223", Owner.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        Empty.setPhoneNumber("999999999");
        assertEquals("999999999", Empty.getPhoneNumber());
    }

    @Test
    void getEmail() {
        assertEquals("nowak@gmail.com", Owner.getEmail());
    }

    @Test
    void setEmail() {
        Empty.setEmail("empty@gmail.com");
        assertEquals("empty@gmail.com", Empty.getEmail());
    }

    @Test
    void getForname() {
    }

    @Test
    void setForname() {
    }

    @Test
    void getSurname() {
    }

    @Test
    void setSurname() {
    }

    @Test
    void getPesel() {
    }

    @Test
    void setPesel() {
    }

    @Test
    void getNameCompany() {
    }

    @Test
    void setNameCompany() {
    }

    @Test
    void getNip() {
    }

    @Test
    void setNip() {
    }

    @Test
    void testEquals() {
    }
}