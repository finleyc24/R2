package edu.hanover.schedulevisualizer.core;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;

public class TimeSlotTest {
    @Test
    public void canCreateTimeSlot() {
        List<Weekday> weekdayList = Weekday.MWF();
        int slotnum = 1;
        TimeSlot timeslot1 = new TimeSlot(weekdayList, slotnum);
        assertEquals(slotnum, timeslot1.slotnum);
        assertEquals(weekdayList, timeslot1.weekdayList);
    }
}
