
package edu.hanover.schedulevisualizer.core;

import java.util.List;
import java.util.function.Consumer;


public class UnassignedTimeSlot implements TimeSlot {

    public UnassignedTimeSlot(){

    }

    public List<Weekday> getWeekdayList() {
        return List.of();
    }

    public boolean overlaps(TimeSlot otherSlot) {
        return false;
    }

    public void ifAssignedSlotNumberDo(Consumer<Integer> f) {
        // Do nothing if timeslot is not assigned number
    }


    public void ifUnassignedSlotDo(Runnable runnable) {
        runnable.run();
    }
}
