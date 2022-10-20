package edu.hanover.schedulevisualizer.core;

public class Context {
    private static Context Instance = new Context();//creates one
    private Context(){};//prevents others from calling

    public static Context getInstance() {
        return Instance;

    }
}
