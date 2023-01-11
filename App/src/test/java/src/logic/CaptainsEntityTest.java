package src.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaptainsEntityTest {


    CaptainsEntity myCaptain = new CaptainsEntity("Jan", "Długosz", "10101001", 1);
    CaptainsEntity myCaptain2 = new CaptainsEntity("Maciek", "Pudzianowski", "11111111111", 13);
    CaptainsEntity emptyCaptain = new CaptainsEntity("", "", "", 0);
    @Test
    void getForename() {
        assertEquals("Jan", myCaptain.getForename());
        assertEquals("", emptyCaptain.getForename());
    }


    @Test
    void setForename() {
        myCaptain.setForename("Mariusz");
        assertEquals("Mariusz", myCaptain.getForename());
    }

    @Test
    void getSurname() {
        assertEquals("Długosz", myCaptain.getSurname());
        assertEquals("", emptyCaptain.getSurname());
    }

    @Test
    void setSurname() {
        myCaptain.setSurname("Kowalski");
        assertEquals("Kowalski", myCaptain.getSurname());
    }

    @Test
    void getPesel() {
        assertEquals("10101001", myCaptain.getPesel());
        assertEquals("", emptyCaptain.getPesel());
    }

    @Test
    void setPesel() {
        myCaptain.setPesel("10101010101");
        assertEquals("10101010101", myCaptain.getPesel());
    }

    @Test
    void getCaptainId() {
        assertEquals(1, myCaptain.getCaptainId());
        assertEquals(0, emptyCaptain.getCaptainId());
    }

    @Test
    void setCaptainId() {
        myCaptain.setCaptainId(2);
        assertEquals(2, myCaptain.getCaptainId());
    }

    @Test
    void setNegativeCaptainID() {
        myCaptain.setCaptainId(-1);
        assertEquals(-1, myCaptain.getCaptainId());
//        assertThrows(IllegalArgumentException.class, () -> { myCaptain.setCaptainId(-1);});
    }

    @Test
    void testEquals() {
        assertEquals(true, myCaptain2.equals(myCaptain2));
        var newCaptain2 = new CaptainsEntity("Maciek", "Pudzianowski", "11111111111", 13);
        assertEquals(true, myCaptain2.equals(newCaptain2));
        assertEquals(false, myCaptain.equals(myCaptain2));
    }

}