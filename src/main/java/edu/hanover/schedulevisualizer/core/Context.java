package edu.hanover.schedulevisualizer.core;

import java.util.List;

public class Context {
    private static Context instance = new Context();//creates one
    private Context(){};//prevents others from calling

    public static Context getInstance() {
        return instance;

    }

    public List<Course> getData() {
        return List.of(
                new Course("CS", "220", "Fundamentals of Computer Science", new TimeSlot(Weekday.MWF(), 1)),
                new Course("MAT", "121", "Calculus I", new TimeSlot(Weekday.MW(), 1))
        );
    }
}
