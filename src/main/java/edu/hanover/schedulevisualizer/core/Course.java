package edu.hanover.schedulevisualizer.core;

import java.util.List;

public class Course {
    private final TimeSlot timeslot;
    private final String prefix;
    private final String courseNum;
    private final String courseName;


    public Course(String prefix, String courseNum, String courseName, TimeSlot timeslot) {
        this.prefix = prefix;
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.timeslot = timeslot;
    }


    public String getPrefix() {
        return prefix;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public TimeSlot getTimeslot() { return timeslot; }

    public String getCourseCode() {
        return prefix + " " + courseNum;
    }

    public List<Weekday> getWeekdays() { return timeslot.getWeekdayList(); }

}
