package mikep.babysitter.time;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.HOURS;

public class Time {

    private final LocalTime EARLIEST_TIME = LocalTime.parse("17:00");
    private final LocalTime LATEST_TIME = LocalTime.parse("04:00");
    private final LocalTime MIDNIGHT = LocalTime.parse("00:00");
    private LocalTime startTime;
    private LocalTime bedTime;
    private LocalTime endTime;

    public Time(String startTime, String bedTime, String endTime){

        this.startTime = parseTime(startTime);
        this.endTime = parseTime(endTime);
        this.bedTime = parseTime(bedTime);

    }


    public boolean isValid(){

        boolean validStartTime = compareTimes(EARLIEST_TIME, startTime);
        boolean validEndTime =  compareTimes(endTime, LATEST_TIME);
        boolean validBedTime = compareTimes(startTime, bedTime) && compareTimes(bedTime, MIDNIGHT) && compareTimes(bedTime, endTime);
        boolean validTimeRange = compareTimes(startTime, endTime);


        return validTimeRange && validStartTime && validEndTime && validBedTime;

    }

    public int getStartToBedTimeHours(){
        return 0;
    }

    public int getBedTimeToMidnightHours(){
        return 0;
    }
    public int getMidnightToEndTimeHours(){
        return 0;
    }

    //Need this to compare times in case one time is before midnight and the other is not.
    //LocalTime doesn't correctly do this since it has no since of days.
    private boolean compareTimes(LocalTime earliestTime, LocalTime latestTime) {

        if(earliestTime.getHour() >= 12 && latestTime.getHour() < 12){
            return true;
        }
        else if(earliestTime.getHour() < 12 && latestTime.getHour() >= 12){
            return false;
        }
        else {
            return earliestTime.compareTo(latestTime) <= 0;
        }

    }

    private LocalTime parseTime(String time){

        String[] timeParts = time.split(":");
        boolean isPM = timeParts[1].contains("PM");
        timeParts[1] = timeParts[1].replaceAll("AM|PM", "");

        if(isPM){
            int hour = Integer.parseInt(timeParts[0]) + 12;
            timeParts[0] = String.valueOf(hour);
        }
        if(timeParts[0].equals("12") && !isPM) {
            timeParts[0] = "00";
        }
        if(timeParts[0].length() == 1){
            timeParts[0] = "0" + timeParts[0];
        }

        String convertedTime = timeParts[0] + ":" + timeParts[1];

        return LocalTime.parse(convertedTime);
    }

}
