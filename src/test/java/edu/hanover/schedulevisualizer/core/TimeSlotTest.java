package edu.hanover.schedulevisualizer.core;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeSlotTest {
    @Test
    public void canCreateTimeSlot() {
        assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(Weekday.MWF(), 1);
        assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(Weekday.TR(), 8);
        assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(Weekday.MWF(), 4);
    }

    private static void assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(List<Weekday> weekdayList, int slot) {
        TimeSlot timeslot = new TimeSlot(weekdayList, slot);
        assertThat(timeslot.slotnum, equalTo(slot));
        assertThat(timeslot.weekdayList, equalTo(weekdayList));
    }

    @Test
    public void slotNumIsEqualToCorrectStartTime() {
        assertTimeSlotHasStartTimeOf(1, 8, 0);
        assertTimeSlotHasStartTimeOf(2, 9, 20);
        assertTimeSlotHasStartTimeOf(3, 10, 40);
        assertTimeSlotHasStartTimeOf(4, 12, 0);
        assertTimeSlotHasStartTimeOf(5, 1, 20);
        // TODO Add more
    }

    private void assertTimeSlotHasStartTimeOf(int slotnum, int hours, int minutes) {
        List<Weekday> dummyWeekdayList = List.of();
        TimeSlot timeslot = new TimeSlot(dummyWeekdayList, slotnum);
        DayTime startTime = new DayTime(hours, minutes);
        assertThat(timeslot.getStartTime(), equalTo(startTime));
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

    @Disabled
    @Test
    void slotNumIsEqualToCorrectWeekday() {
        assertThrows(RuntimeException.class, () -> { new TimeSlot(Weekday.TR(), 1); });
        // TODO: Add more
    }
}
