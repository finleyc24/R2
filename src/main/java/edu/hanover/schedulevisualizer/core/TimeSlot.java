package edu.hanover.schedulevisualizer.core;

import java.util.List;
import java.util.function.Consumer;

public interface TimeSlot {

    List<Weekday> getWeekdayList();

    boolean overlaps(TimeSlot otherSlot);

    void ifAssignedSlotNumberDo(Consumer<Integer> f);

    void ifUnassignedSlotDo(Runnable runnable);
}
