package edu.hanover.schedulevisualizer.core;
import java.util.List;

public class TimeSlot {
    private List<Weekday> weekdayList;
    public int slotnum;

    public TimeSlot(List<Weekday> weekdayList, int slotnum){
        this.weekdayList = weekdayList;
        this.slotnum = slotnum;
    }

    public DayTime getStartTime() {
        return switch (slotnum) {
            case 1 -> new DayTime(8, 0);
            case 2 -> new DayTime(9, 20);
            case 3 -> new DayTime(10, 40);
            case 4 -> new DayTime(12, 0);
            case 5 -> new DayTime(1, 20);
            case 6 -> new DayTime(2, 40);
            case 7 -> new DayTime(8, 0);
            case 8 -> new DayTime(10, 0);
            case 9 -> new DayTime(12, 20);
            case 10->  new DayTime(2, 15);
            default -> throw new RuntimeException("Not a Valid startTime for this class!");
        };
    }

    public DayTime getEndTime() {
        return switch (slotnum) {
            case 1 -> new DayTime(9, 10);
            case 2 -> new DayTime(10, 30);
            case 3 -> new DayTime(11, 50);
            case 4 -> new DayTime(1, 10);
            case 5 -> new DayTime(2, 30);
            case 6 -> new DayTime(3, 50);
            case 7 -> new DayTime(9, 45);
            case 8 -> new DayTime(11, 45);
            case 9 -> new DayTime(2, 5);
            case 10 -> new DayTime(4, 0);
            default -> throw new RuntimeException("Not a Valid endTime for this class!");
        };
    }
    public List<Weekday> getWeekdayList(){
        return weekdayList;
    }

    public boolean overlaps(TimeSlot otherSlot) {
        if (otherSlot.slotnum != slotnum){
            return false;
        }
        if (noDaysTheSameIn(otherSlot)){return false;}
        return true;

    }


    private boolean noDaysTheSameIn(TimeSlot otherSlot) {
        for(Weekday day1 : weekdayList) {
            for (Weekday day2 : otherSlot.weekdayList) {
                if (day1 == day2){
                    return false;
                }
            }
        }
        return true;
    }
}
