
package edu.hanover.schedulevisualizer.core;

import java.util.List;



public class UnassignedTimeSlot implements TimeSlot {


    public UnassignedTimeSlot(){

    }

    @Override
    public List<Weekday> getWeekdayList() {
        return List.of();
    }

    @Override
    public boolean overlaps(TimeSlot otherSlot) {
        return false;
    }
}
