package edu.hanover.schedulevisualizer.core;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TimeSlotTest {
    @Test
    public void canCreateTimeSlot() {
        List<Weekday> weekdayList = Weekday.MWF();
        int slotnum = 1;
        TimeSlot timeslot1 = new TimeSlot(weekdayList, slotnum);
        assertThat(timeslot1.slotnum, equalTo(slotnum));
        assertThat(timeslot1.weekdayList, equalTo(weekdayList));
    }

//    @Test
//    public void getStartTimeWorks() {
//
//    }

    @Test
    public void timeSlotIsCorrect() {

    }
}
