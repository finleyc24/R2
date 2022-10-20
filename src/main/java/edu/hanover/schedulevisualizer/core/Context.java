package edu.hanover.schedulevisualizer.core;

import java.util.List;

public class Context {
    private static Context Instance = new Context();//creates one
    private Context(){};//prevents others from calling

    public static Context getInstance() {
        return Instance;

    }

    public static List<Course> getData() {
        return List.of(
                new Course(new TimeSlot(Weekday.MWF(), 1), "CS", "220","Fundamentals of Computer Science"),
                new Course(new TimeSlot(Weekday.MW(), 1), "MAT", "121","Calculus I")
        );
    }
}
