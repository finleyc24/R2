package edu.hanover.schedulevisualizer.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HCTimeSlotTest {
    @Test
    public void canCreateTimeSlot() {
        assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(Weekday.MWF(), 1);
        assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(Weekday.TR(), 8);
        assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(Weekday.MWF(), 4);
    }

    private static void assertCreatedTimeSlotHasCorrectWeekdaysAndSlotnum(List<Weekday> weekdayList, int slot) {
        AssignedTimeSlot timeslot = new AssignedTimeSlot(weekdayList, slot);
        assertThat(timeslot.slotnum, equalTo(slot));
        assertThat(timeslot.getWeekdayList(), equalTo(weekdayList));
    }

    @Test
    public void slotNumIsEqualToCorrectStartTime() {
        assertTimeSlotHasStartTimeOf(1, 8, 0);
        assertTimeSlotHasStartTimeOf(2, 9, 20);
        assertTimeSlotHasStartTimeOf(3, 10, 40);
        assertTimeSlotHasStartTimeOf(4, 12, 0);
        assertTimeSlotHasStartTimeOf(5, 1, 20);
        assertTimeSlotHasStartTimeOf(7, 8, 0);
        assertTimeSlotHasStartTimeOf(8,10,0);
        assertTimeSlotHasStartTimeOf(9,12,20);
        assertTimeSlotHasStartTimeOf(10, 2,15);
        assertThrows(RuntimeException.class, () -> { (new AssignedTimeSlot(List.of(), 11)).getStartTime();});
    }

    @Test
    public void slotNumIsEqualToCorrectEndTime() {
        assertTimeSlotHasEndTimeOf(1,9,10);
        assertTimeSlotHasEndTimeOf(2,10,30);
        assertTimeSlotHasEndTimeOf(3,11,50);
        assertTimeSlotHasEndTimeOf(4,1,10);
        assertTimeSlotHasEndTimeOf(5,2,30);
        assertTimeSlotHasEndTimeOf(6,3,50);
        assertTimeSlotHasEndTimeOf(7,9,45);
        assertTimeSlotHasEndTimeOf(8, 11,45);
        assertTimeSlotHasEndTimeOf(9,2,5);
        assertTimeSlotHasEndTimeOf(10, 4,0);
        assertThrows(RuntimeException.class, () -> { (new AssignedTimeSlot(List.of(), 11)).getEndTime();});
    }

    private void assertTimeSlotHasStartTimeOf(int slotnum, int hours, int minutes) {
        List<Weekday> dummyWeekdayList = List.of();
        AssignedTimeSlot timeslot = new AssignedTimeSlot(dummyWeekdayList, slotnum);
        DayTime startTime = new DayTime(hours, minutes);
        assertThat(timeslot.getStartTime(), equalTo(startTime));
    }
    private void assertTimeSlotHasEndTimeOf(int slotnum, int hours, int minutes) {
        List<Weekday> dummyWeekdayList = List.of();
        AssignedTimeSlot timeslot = new AssignedTimeSlot(dummyWeekdayList, slotnum);
        DayTime endTime = new DayTime(hours, minutes);
        assertThat(timeslot.getEndTime(), equalTo(endTime));
    }

    @Test
    public void testOverlapsDifferentSlotNum(){
        List<Weekday> thurs1 = List.of(Weekday.Thursday);
        AssignedTimeSlot timeSlot1 = new AssignedTimeSlot(thurs1, 6);

        List<Weekday> thurs2 = List.of(Weekday.Thursday);
        AssignedTimeSlot timeSlot2 = new AssignedTimeSlot(thurs2, 6);

        List<Weekday> thurs3 = List.of(Weekday.Thursday);
        AssignedTimeSlot timeSlot3 = new AssignedTimeSlot(thurs3, 7);

        assertTrue(timeSlot1.overlaps(timeSlot2));
        assertFalse(timeSlot1.overlaps(timeSlot3));
    }
    @Test
    public void testOverlapsDifferentDay(){
        List<Weekday> thurs1 = List.of(Weekday.Thursday);
        AssignedTimeSlot thursSlot1 = new AssignedTimeSlot(thurs1, 6);

        List<Weekday> friday1 = List.of(Weekday.Friday);
        AssignedTimeSlot friSlot1 = new AssignedTimeSlot(friday1, 6);

        List<Weekday> thurs3 = List.of(Weekday.Thursday);
        AssignedTimeSlot thursSlot2 = new AssignedTimeSlot(thurs3, 6);

        assertFalse(thursSlot1.overlaps(friSlot1));
        assertTrue(thursSlot1.overlaps(thursSlot2));
    }

}
