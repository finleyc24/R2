package edu.hanover.schedulevisualizer.core;

import edu.hanover.schedulevisualizer.observable.MyObserver;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private static Context instance = new Context();//creates one
    private List<MyObserver<List<Course>>> observers = new ArrayList<>();
    private List<Course> data = List.of();

    private Context(){};//prevents others from calling

    public static Context getInstance() {
        return instance;

    }

    public void getData() {
        this.data = List.of(
                new Course("CS", "220", "Fundamentals of Computer Science", new HCTimeSlot(Weekday.MWF(), 1)),
                new Course("MAT", "121", "Calculus I", new HCTimeSlot(List.of(Weekday.Tuesday), 7))
        );
        notifyObservers();
    }

    public void addObserver(MyObserver<List<Course>> observer) {
        observers.add(observer);
    }

    void notifyObservers() {
        observers.forEach((obj) -> obj.update(data));
    }
}
