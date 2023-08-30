package com.injecaoDependencias.springcoredemo.common;

public class SwinCoach implements Coach {

    public SwinCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Nadando...";
    }
}
