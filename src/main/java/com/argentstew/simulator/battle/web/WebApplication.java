package com.argentstew.simulator.battle.web;

import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * com.argentstew.simulator.battle.web
 * 4/16/2020
 *
 * @author argen
 */
@SpringBootApplication(
        scanBasePackages = {"com.argentstew.simulator.battle.web"},
        exclude = {ErrorMvcAutoConfiguration.class})
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public VgFighterFactory fighterFactory() {
        return new VgFighterFactory();
    }
}
