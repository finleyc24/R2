package edu.hanover.schedulevisualizer.core;
import java.util.List;

public class TimeSlot {
    public List<Weekday> weekdayList;
    public int slotnum;

    public TimeSlot(List<Weekday> weekdayList, int slotnum){
        this.weekdayList=weekdayList;
        this.slotnum=slotnum;
    }

}
