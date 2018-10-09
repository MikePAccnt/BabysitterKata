package mikep.babysitter.babysitter;

import mikep.babysitter.time.Time;
import mikep.babysitter.time.WorkDay;

public class BabySitterDay implements WorkDay {

    private Time time;
    private final int START_TO_BED = 12;
    private final int BED_TO_MIDNIGHT = 8;
    private final int MIDNIGHT_TO_END = 16;

    public BabySitterDay(Time time){
        this.time = time;
    }

    @Override
    public double getPay() {
        return (time.getStartToBedTimeHours() * START_TO_BED)
                + (time.getBedTimeToMidnightHours() * BED_TO_MIDNIGHT)
                + (time.getMidnightToEndTimeHours() * MIDNIGHT_TO_END);
    }


}
