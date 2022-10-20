package edu.hanover.schedulevisualizer.core;

public class Course {
    public  TimeSlot timeslot1;
    public  String prefix;
    public  String courseNum;
    public  String courseName;

    public Course(TimeSlot timeslot1, String prefix, String courseNum, String courseName){
        this.timeslot1 = timeslot1;
        this.prefix = prefix;
        this.courseNum = courseNum;
        this.courseName = courseName;
    }

}
