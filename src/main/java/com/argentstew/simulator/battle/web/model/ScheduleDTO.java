package com.argentstew.simulator.battle.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * com.argentstew.simulator.battle.web.model
 * 5/2/2020
 *
 * @author argen
 */
@Data
public class ScheduleDTO {

    @JsonFormat(pattern = "E MM-dd-YYYY")
    private Date date;
    private String homeTeam;
    private String awayTeam;
    private String winner;
}
