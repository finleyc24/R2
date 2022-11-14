
package edu.hanover.schedulevisualizer.core;

import java.util.List;
import java.util.function.Consumer;


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

    public void ifAssignedSlotNumberDo(Consumer<Integer> f) {
        // Do nothing if timeslot is not assigned number
    }
}
