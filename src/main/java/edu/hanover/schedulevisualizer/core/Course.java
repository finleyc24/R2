package edu.hanover.schedulevisualizer.core;

public class Course {
    public  TimeSlot timeSlot;
    public  String prefix;
    public  String courseNum;
    public  String courseName;

    public Course(TimeSlot timeslot1, String prefix, String courseNum, String courseName){
        this.timeSlot = timeslot1;
        this.prefix = prefix;
        this.courseNum = courseNum;
        this.courseName = courseName;
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

    public String createCourseCode(String prefix, String courseNum) {
        return prefix + " "+ courseNum;
    }
}
