package edu.hanover.schedulevisualizer.core;

import java.util.List;

public interface TimeSlot {

    List<Weekday> getWeekdayList();

    boolean overlaps(TimeSlot otherSlot);
}
