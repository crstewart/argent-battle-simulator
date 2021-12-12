package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.service.LeagueService;
import com.argentstew.simulator.battle.web.service.TeamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * com.argentstew.simulator.battle.web.controller
 * 5/2/2020
 *
 * @author argen
 */
@RestController
@RequestMapping("/v1/seasons/2")
public class SeasonTwoLeagueController {

    private static final Logger LOG = LogManager.getLogger(SeasonTwoLeagueController.class);

    private static final String SEASON_TWO_ID = "5228e89b-5ec7-4d1e-ac0a-cd60337828dd";

    private final LeagueService leagueService;
    private final TeamService teamService;

    @Autowired
    public SeasonTwoLeagueController(LeagueService leagueService,
                                     TeamService teamService) {
        this.leagueService = leagueService;
        this.teamService = teamService;
    }

    @GetMapping(path = "/teams", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getTeams() {
        try {
            List<String> teams = leagueService.getTeamsBySeason(SEASON_TWO_ID);
            LOG.info("Retrieved list of teams");
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/standings", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandingsDTO>> getStandings() {
        try {
            List<StandingsDTO> standings = leagueService.getStandings(SEASON_TWO_ID);
            LOG.info("Retrieved standings");
            return new ResponseEntity<>(standings, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/rosters", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getRosterByTeam(@RequestParam("team") String teamName) {
        try {
            List<String> roster = teamService.getRosterByTeam(SEASON_TWO_ID, teamName);
            LOG.info("Retrieved roster of {}", teamName);
            return new ResponseEntity<>(roster, HttpStatus.OK);
        } catch (LeagueException e) {
            LOG.error("An error occurred fetching roster for the given team name", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/weeks", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> getWeeks() {
        try {
            List<Integer> weeks = leagueService.getWeeks(SEASON_TWO_ID);
            LOG.info("Retrieved weeks of the season");
            return new ResponseEntity<>(weeks, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/schedule", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleDTO>> getSchedule(@RequestParam(required = false) String teamName,
                                                         @RequestParam(required = false) Integer week) {
        try {
            List<Integer> weeks = leagueService.getWeeks(SEASON_TWO_ID);
            int minWeek = weeks.get(0);
            int maxWeek = weeks.get(weeks.size() - 1);
            if (week == null) {
                List<ScheduleDTO> schedule = (teamName == null) ? leagueService.getFullScheduleForSeason(SEASON_TWO_ID)
                        : leagueService.getFullScheduleForTeam(teamService.getTeam(SEASON_TWO_ID, teamName));
                LOG.info("Retrieved full schedule{}", (teamName == null) ? "" : " for " + teamName);
                return new ResponseEntity<>(schedule, HttpStatus.OK);
            } else if (week < minWeek || week > maxWeek) {
                LOG.error("Bad week given");
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
            } else {
                List<ScheduleDTO> weeklySchedule = (teamName == null)
                        ? leagueService.getWeeklyScheduleForSeason(SEASON_TWO_ID, week)
                        : leagueService.getWeeklyScheduleForTeam(teamService.getTeam(SEASON_TWO_ID, teamName), week);
                LOG.info("Retrieved schedule{} for week {}", (teamName == null) ? "" : " for " + teamName, week);
                return new ResponseEntity<>(weeklySchedule, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
