package edu.hanover.schedulevisualizer.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TimeSlotTest {
    @Test
    public void canCreateTimeSlot() {
        createTimeSlotAndCheckFields(Weekday.MWF(), 1);
        createTimeSlotAndCheckFields(Weekday.TR(), 8);
        createTimeSlotAndCheckFields(Weekday.MWF(), 4);
    }

    private static void createTimeSlotAndCheckFields(List<Weekday> weekdayList, int slot) {
        TimeSlot timeslot1 = new TimeSlot(weekdayList, slot);
        assertThat(timeslot1.slotnum, equalTo(slot));
        assertThat(timeslot1.weekdayList, equalTo(weekdayList));
    }

    @Test
    public void slotNumIsEqualToCorrectStartTime() {
        TimeSlot timeslot = new TimeSlot(Weekday.MWF(),1);
        TimeSlot timeslot2 = new TimeSlot(Weekday.TR(),7);
        DayTime startTime = new DayTime(8,00);
        assertThat(startTime, equalTo(timeslot.getStartTime()));
    }

    @Test
    void slotNumIsEqualToCorrectEndTime() {
        TimeSlot timeslot = new TimeSlot(Weekday.MWF(),1);
        DayTime endTime = new DayTime(9,10);
        assertThat(timeslot.slotnum, equalTo(1));
        assertThat(endTime, equalTo(timeslot.getEndTime()));
        TimeSlot timeslot2 = new TimeSlot(Weekday.TR(),7);
        DayTime endTime2 = new DayTime(9,45);
        assertThat(timeslot2.slotnum, equalTo(7));
        assertThat(endTime2, equalTo(timeslot2.getEndTime()));
    }

    @Test
    void slotNumIsEqualToCorrectWeekday() {
        TimeSlot timeslot1 = new TimeSlot(Weekday.MWF(), 1);
        TimeSlot timeslot2 = new TimeSlot(Weekday.TR(), 10);
        assertThat(timeslot1.weekdayList, equalTo(timeslot1.getWeekdayList()));
        assertThat(timeslot2.weekdayList, equalTo(timeslot2.getWeekdayList()));
    }
}
