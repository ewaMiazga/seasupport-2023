package src.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RegistrationDialogTest {

    @Test
    void handle() {
//        var myObj = mock(RegistrationDialog.class);
//        when(myObj.handle();)
//        when(myObj.createStringConverter()).thenReturn(0);

    }

    @Test
    void stringConverter() {
        var obj = new RegistrationDialog();
        var stringConverter = obj.createStringConverter();
        var convertedDate = stringConverter.fromString("15/12/22");
        var date = LocalDate.of(2022, 12, 15);
        assertEquals(date, convertedDate);

    }

}