package com.argentstew.simulator.battle.web.model;

import com.argentstew.simulator.battle.web.persistence.Match;
import com.argentstew.simulator.battle.web.persistence.MatchStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * com.argentstew.simulator.battle.web.model
 * 5/2/2020
 *
 * @author argen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    @JsonFormat(pattern = "E MM-dd-YYYY")
    private LocalDate date;
    private String homeTeam;
    private String awayTeam;
    private String winner;

    public static ScheduleDTO from(Match match) {
        return ScheduleDTO.builder().date(match.getStartDate().toLocalDate()).homeTeam(match.getHomeTeam().getName())
                .awayTeam(match.getAwayTeam().getName()).winner(determineWinner(match)).build();
    }

    private static String determineWinner(Match match) {
        if (match.getWinner() == MatchStatus.HOME_TEAM_WINS) {
            return match.getHomeTeam().getName();
        } else if (match.getWinner() == MatchStatus.AWAY_TEAM_WINS) {
            return match.getAwayTeam().getName();
        } else if (match.getWinner() == MatchStatus.DRAW) {
            return MatchStatus.DRAW.toString();
        }

        return "";
    }
}
