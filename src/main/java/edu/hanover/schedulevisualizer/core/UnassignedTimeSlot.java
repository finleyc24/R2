
package edu.hanover.schedulevisualizer.core;

import java.util.List;
import java.util.function.Consumer;


public class UnassignedTimeSlot implements TimeSlot {
 public int slotnum;

    public UnassignedTimeSlot(int slotnum){
    this.slotnum = slotnum;
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

    public void ifUnAssignedSlotNumberDo(Consumer<Integer> f){
        f.accept(slotnum);
    }
}
