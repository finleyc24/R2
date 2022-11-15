package edu.hanover.schedulevisualizer.core;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class CourseTest {
    @Test
    public void canCreateCourse(){
        assertCreatedCourseHasCorrectParameters("Data Structures", "223", "CS", new HCTimeSlot(Weekday.MWF(), 1));
        assertCreatedCourseHasCorrectParameters("System Fundamentals", "231", "CS", new HCTimeSlot(Weekday.TR(), 7));
        assertCreatedCourseHasCorrectParameters("Discrete Mathematics", "243", "MAT", new HCTimeSlot(Weekday.MWF(), 3));
    }

    private static void assertCreatedCourseHasCorrectParameters(String courseName, String courseNum, String prefix, HCTimeSlot timeslot1) {
        Course course1 = new Course(prefix, courseNum, courseName, timeslot1);
        assertThat(course1.getPrefix(), equalTo(prefix));
        assertThat(course1.getCourseNum(), equalTo(courseNum));
        assertThat(course1.getCourseName(), equalTo(courseName));
        assertThat(course1.getTimeslot(), equalTo(timeslot1));
    }
    @Test
    public void canCombinePrefixAndCourseNumber(){
        Course course1 = new Course("CS", "223", "Data Structures", new HCTimeSlot(Weekday.MWF(), 1));
        assertThat(course1.getCourseCode(), equalTo("CS 223"));
    }

    @Test
    public void canConstructorWorkWithNullTimeSlot() {
        UnassignedTimeSlot nulltimeslot = new UnassignedTimeSlot();
        Course course1 = new Course("CS", "223", "Data Structures", nulltimeslot);
        assertThat(course1.getTimeslot(), equalTo(nulltimeslot));

    }
}
