package edu.hanover.schedulevisualizer.core;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CourseTest {
    @Test
    public void canCreateCourse(){
        assertCreatedCourseHasCorrectParameters("Data Structures", "223", "CS", new TimeSlot(Weekday.MWF(), 1));
        assertCreatedCourseHasCorrectParameters("System Fundamentals", "231", "CS", new TimeSlot(Weekday.TR(), 7));
    }

    private static void assertCreatedCourseHasCorrectParameters(String courseName, String courseNum, String prefix, TimeSlot timeslot1) {
        Course course1 = new Course(timeslot1, prefix, courseNum, courseName);
        assertThat(course1.prefix, equalTo(prefix));
        assertThat(course1.courseNum, equalTo(courseNum));
        assertThat(course1.courseName, equalTo(courseName));
        assertThat(course1.timeslot1, equalTo(timeslot1));
    }


}
