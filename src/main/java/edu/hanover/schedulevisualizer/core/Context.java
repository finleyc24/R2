package edu.hanover.schedulevisualizer.core;

import edu.hanover.schedulevisualizer.observable.MyObserver;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private static Context instance = new Context();//creates one
    private List<MyObserver<List<Course>>> observers = new ArrayList<>();
    private List<Course> courses;

    private Context(){
        this.courses = List.of(
                new Course("CS", "220", "Fundamentals of Computer Science", new HCTimeSlot(Weekday.MWF(), 1)),
                new Course("MAT", "121", "Calculus I", new HCTimeSlot(List.of(Weekday.Tuesday), 7)),
                new Course("FY", "101", "First Year", new UnassignedTimeSlot()),
                new Course("FY2", "102", "First Year2", new UnassignedTimeSlot())
                              );
    };//prevents others from calling

    public static Context getInstance() {
        return instance;

    }

    public void getData() {
        notifyObservers();
    }

    public void addObserver(MyObserver<List<Course>> observer) {
        observers.add(observer);
    }

    void notifyObservers() {
        observers.forEach((obj) -> obj.update(courses));
    }

    public Course getCourseWithId(Long courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        throw new RuntimeException("Cannot find course with id: " + courseId);
    }
}
