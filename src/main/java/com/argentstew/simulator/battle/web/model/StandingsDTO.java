package com.argentstew.simulator.battle.web.model;

import lombok.Data;

/**
 * com.argentstew.simulator.battle.web.model
 * 5/2/2020
 *
 * @author argen
 */
@Data
public class StandingsDTO {

    private String team;
    private String division;
    private int wins;
    private int losses;
    private int draws;

    public double getWinPercentage() {
        int totalMatches = wins + losses + draws;
        return (totalMatches != 0) ? ((wins + (draws / 2.0)) / (totalMatches)) : 0;
    }
}
