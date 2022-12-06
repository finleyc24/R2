package edu.hanover.schedulevisualizer.core;

import edu.hanover.schedulevisualizer.observable.MyObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private static Context instance = new Context();//creates one
    private Map<String, TimeSlot> createdTimeslots = new HashMap<>();
    private List<MyObserver<List<Course>>> observers = new ArrayList<>();
    private List<Course> courses;

    private Context(){
        this.courses = List.of(
                new Course("CS", "220", "Fundamentals of Computer Science", makeAssignedTimeSlot(Weekday.MWF(), 1)),
                new Course("MAT", "121", "Calculus I", makeAssignedTimeSlot(List.of(Weekday.Tuesday), 7)),
                new Course("FY", "101", "First Year", makeUnassignedTimeslot()),
                new Course("FY2", "102", "First Year2", makeUnassignedTimeslot())
                              );
    }

    public TimeSlot makeUnassignedTimeslot() {
        return addIfNeededThenReturn(UnassignedTimeSlot.getInstance());
    }

    public TimeSlot makeAssignedTimeSlot(List<Weekday> Tuesday, int slotnum) {
        return addIfNeededThenReturn(new AssignedTimeSlot(Tuesday, slotnum));
    }

    private TimeSlot addIfNeededThenReturn(TimeSlot timeSlot) {
        if (createdTimeslots.containsKey(timeSlot.getId())) {
            return createdTimeslots.get(timeSlot.getId());
        }
        createdTimeslots.put(timeSlot.getId(), timeSlot);
        return timeSlot;
    }

    ;//prevents others from calling

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

    public TimeSlot getTimeslotWithId(String timeslotId) {
        // TODO: Add error-checking if id doesn't exist
        if (!createdTimeslots.containsKey(timeslotId))
            throw new RuntimeException("Should not have a timeslot id that is not stored");
        return createdTimeslots.get(timeslotId);
    }

    public void moveCourseToTimeslot(Long courseId, String timeslotId) {
        Course course = getCourseWithId(courseId);
        TimeSlot timeslot = getTimeslotWithId(timeslotId);
        course.setTimeslot(timeslot);
        System.out.println("Dropped: " + course + timeslot);
    }
}
