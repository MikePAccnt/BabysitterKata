package mikep.babysitter.babysitter;

import mikep.babysitter.time.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBabySitterDay {

    //region getPayTest

    @DisplayName("Test getPay: With EndTime after Midnight")
    @Test
    public void testGetPay(){

        Time time = new Time("6:00PM", "8:00PM", "2:00AM");
        BabySitterDay day = new BabySitterDay(time);
        //start -> bed = 2 * 12 = 24
        //bed -> midnight = 4 * 8 = 32
        //midnight -> end = 2 * 16 = 32
        //total = 24 + 32 + 32 = 88

        Assertions.assertEquals(88, day.getPay());

    }

    @DisplayName("Test getPay: With EndTime before Midnight")
    @Test
    public void testGetPayEndBeforeMidnight(){

        Time time = new Time("6:00PM", "8:00PM", "11:00PM");
        BabySitterDay day = new BabySitterDay(time);
        //start -> bed = 2 * 12 = 24
        //bed -> midnight = 3 * 8 = 24
        //midnight -> end = 0 * 16 = 0
        //total = 24 + 24 + 0 = 48

        Assertions.assertEquals(48, day.getPay());

    }

    @DisplayName("Test getPay: With invalid Time")
    @Test
    public void testGetPayInvalid(){

        Time time = new Time("6:00PM", "8:00PM", "5:00AM");
        BabySitterDay day = new BabySitterDay(time);
        //start -> bed = 0 * 12 = 0
        //bed -> midnight = 0 * 8 = 0
        //midnight -> end = 0 * 16 = 0
        //total = 0 + 0 + 0 = 0

        Assertions.assertEquals(0, day.getPay());

    }

    //endregion getPayTests

}
