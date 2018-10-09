package mikep.babysitter.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimeTests {

    //region isValidTests
    @DisplayName("Test valid time: StartTime No earlier than 5:00PM")
    @Test
    public void testIsValidTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("4:00PM", "8:00PM" ,"7:00PM");

        Assertions.assertFalse(time.isValid());
    }

    @DisplayName("Test valid time: EndTime No later than 4:00AM")
    @Test
    public void testIsValidTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"5:00AM");

        Assertions.assertFalse(time.isValid());

    }

    @DisplayName("Test valid time: Between 5:00PM and 4:00AM")
    @Test
    public void testIsValidTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"3:00AM");

        Assertions.assertTrue(time.isValid());

    }

    @DisplayName("Test valid time: StartTime At 5:00PM")
    @Test
    public void testIsValidTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("5:00PM", "8:00PM" ,"3:00AM");

        Assertions.assertTrue(time.isValid());

    }

    @DisplayName("Test valid time: EndTime At 4:00AM")
    @Test
    public void testIsValidTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"4:00AM");

        Assertions.assertTrue(time.isValid());

    }

    @DisplayName("Test valid time: BedTime later than EndTime")
    @Test
    public void testIsValidTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"7:00PM");

        Assertions.assertFalse(time.isValid());

    }

    @DisplayName("Test valid time: BedTime earlier than StartTime")
    @Test
    public void testIsValidTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("7:00PM", "6:00PM" ,"9:00PM");

        Assertions.assertFalse(time.isValid());

    }

    //endregion isValidTests

}
