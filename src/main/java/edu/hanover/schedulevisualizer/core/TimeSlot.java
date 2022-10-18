package edu.hanover.schedulevisualizer.core;
import java.util.List;

public class TimeSlot {
    public List<Weekday> weekdayList;
    public int slotnum;

    public TimeSlot(List<Weekday> weekdayList, int slotnum){
        this.weekdayList = weekdayList;
        this.slotnum = slotnum;

    }

    public DayTime getStartTime() {
        return switch (slotnum) {
            case 1 -> new DayTime(8, 00);
            case 2 -> new DayTime(9, 20);
            case 3 -> new DayTime(10, 40);
            case 4 -> new DayTime(12, 00);
            case 5 -> new DayTime(1, 20);
            case 6 -> new DayTime(2, 40);
            case 7 -> new DayTime(8, 00);
            case 8 -> new DayTime(10, 00);
            case 9 -> new DayTime(12, 20);
            case 10->  new DayTime(2, 15);
            default->  new DayTime(0, 0);
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
            case 9 -> new DayTime(2, 05);
            case 10 -> new DayTime(4, 00);
            default -> new DayTime(0, 0);
        };
    }
    public List<Weekday> getWeekdayList(){
        switch (slotnum){
            case 1, 2, 3, 4, 5, 6 -> weekdayList = Weekday.MWF();
            case 7, 8, 9, 10 -> weekdayList = Weekday.TR();
            default -> weekdayList = Weekday.MW();
        }
        return weekdayList;
    }
}
