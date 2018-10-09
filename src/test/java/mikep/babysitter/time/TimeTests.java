package mikep.babysitter.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimeTests {

    //region isValidTests
    @DisplayName("Test valid time: StartTime No earlier than 5:00PM")
    @Test
    public void testIsValidTimeNoEarlier(){

        //StartTime, BedTime, EndTime
        Time time = new Time("4:00PM", "8:00PM" ,"7:00PM");

        Assertions.assertFalse(time.isValid());
    }

    @DisplayName("Test valid time: EndTime No later than 4:00AM")
    @Test
    public void testIsValidTimeNoLater(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"5:00AM");

        Assertions.assertFalse(time.isValid());

    }

    @DisplayName("Test valid time: Between 5:00PM and 4:00AM")
    @Test
    public void testIsValidTimeBetween(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"3:00AM");

        Assertions.assertTrue(time.isValid());

    }

    @DisplayName("Test valid time: StartTime At 5:00PM")
    @Test
    public void testIsValidTimeAt5PM(){

        //StartTime, BedTime, EndTime
        Time time = new Time("5:00PM", "8:00PM" ,"3:00AM");

        Assertions.assertTrue(time.isValid());

    }

    @DisplayName("Test valid time: EndTime At 4:00AM")
    @Test
    public void testIsValidTimeAt4AM(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"4:00AM");

        Assertions.assertTrue(time.isValid());

    }

    @DisplayName("Test valid time: BedTime between StartTime and Midnight")
    @Test
    public void testIsValidTimeBedTimeBetweenStartTimeMidnight(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "7:00PM" ,"12:00AM");

        Assertions.assertTrue(time.isValid());

    }

    @DisplayName("Test valid time: BedTime later than EndTime")
    @Test
    public void testIsValidTimeBedTimeLaterEndTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("6:00PM", "8:00PM" ,"7:00PM");

        Assertions.assertFalse(time.isValid());

    }

    @DisplayName("Test valid time: BedTime earlier than StartTime")
    @Test
    public void testIsValidTimeBedTimeEarlierStartTime(){

        //StartTime, BedTime, EndTime
        Time time = new Time("7:00PM", "6:00PM" ,"9:00PM");

        Assertions.assertFalse(time.isValid());

    }

    @DisplayName("Test valid time: With no BedTime")
    @Test
    public void testIsValidNoBedTime(){
        Time time = new Time("7:00PM", "1:00AM");

        Assertions.assertTrue(time.isValid());
    }

    @DisplayName("Test valid time: With StartTime later than EndTime")
    @Test
    public void testIsValidStartTimeLaterEndTime(){
        Time time = new Time("1:00AM", "7:00PM");

        Assertions.assertFalse(time.isValid());
    }
    //endregion isValidTests


}
