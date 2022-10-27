package edu.hanover.schedulevisualizer.core;

import java.util.List;

public interface TimeSlot {
    DayTime getStartTime();

    DayTime getEndTime();

    List<Weekday> getWeekdayList();

    boolean overlaps(TimeSlot otherSlot);
}
