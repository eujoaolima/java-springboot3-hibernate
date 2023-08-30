package com.injecaoDependencias.springcoredemo.rest;

import com.injecaoDependencias.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public void DemoController(
            @Qualifier("tennisCoach") Coach myCoach,
            @Qualifier("trackCoach") Coach theAnotherCoach
    ) {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
