package mikep.babysitter.time;

import java.time.LocalTime;

public class Time {

    private LocalTime startTime;
    private LocalTime bedTime;
    private LocalTime endTime;

    public Time(String startTime, String bedTime, String endTime){

        this.startTime = parseTime(startTime);
        this.bedTime = parseTime(bedTime);
        this.endTime = parseTime(endTime);

        printTimes();

    }

    public boolean isValid(){
        return false;
    }

    private LocalTime parseTime(String time){

        String[] timeParts = time.split(":");
        boolean isPM = timeParts[1].contains("PM");
        timeParts[1] = timeParts[1].replaceAll("AM|PM", "");

        if(isPM){
            int hour = Integer.parseInt(timeParts[0]) + 12;
            timeParts[0] = String.valueOf(hour);
        }
        if(timeParts[0].length() == 1){
            timeParts[0] = "0" + timeParts[0];
        }

        String convertedTime = timeParts[0] + ":" + timeParts[1];

        return LocalTime.parse(convertedTime);
    }


    private void printTimes(){
        System.out.println("StartTime: " + startTime.toString());
        System.out.println("BedTime: " + bedTime.toString());
        System.out.println("EndTime: " + endTime.toString());
    }
}
