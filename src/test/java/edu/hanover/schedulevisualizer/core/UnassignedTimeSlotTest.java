package edu.hanover.schedulevisualizer.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnassignedTimeSlotTest {

    @Test
    public void weekdayListUnassigned(){
        UnassignedTimeSlot unassignedSlot = new UnassignedTimeSlot();
        assertThat(unassignedSlot.getWeekdayList(), equalTo(List.of()));
    }

    @Test
    public void overlapsTestUnassigned(){
        UnassignedTimeSlot unassignedSlot = new UnassignedTimeSlot();
        assertThat(unassignedSlot.overlaps(new UnassignedTimeSlot()), equalTo(Boolean.FALSE));
        
    }
}
