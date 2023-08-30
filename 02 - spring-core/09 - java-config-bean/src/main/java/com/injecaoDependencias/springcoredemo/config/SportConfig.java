package com.injecaoDependencias.springcoredemo.config;

import com.injecaoDependencias.springcoredemo.common.Coach;
import com.injecaoDependencias.springcoredemo.common.SwinCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwinCoach();
    }
}
