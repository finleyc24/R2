package edu.hanover.schedulevisualizer.core;

import java.util.List;

public class Course {
    private final HCTimeSlot timeSlot;
    private final String prefix;
    private final String courseNum;
    private final String courseName;

    public Course(String prefix, String courseNum, String courseName, HCTimeSlot timeslot) {
        this.prefix = prefix;
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.timeSlot = timeslot;
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

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public String getCourseCode() {
        return prefix + " " + courseNum;
    }

    public List<Weekday> getWeekdays() {
        return timeSlot.getWeekdayList();
    }

    public int getSlotNumber() {
        return timeSlot.slotnum;
    }
}
