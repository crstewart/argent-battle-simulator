package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.service.SeasonOneLeagueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/v1/seasons/1")
public class SeasonOneLeagueController {

    private static final Logger LOG = LogManager.getLogger(SeasonOneLeagueController.class);

    private final SeasonOneLeagueService leagueService;

    @Autowired
    public SeasonOneLeagueController(SeasonOneLeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping(path = "/teams", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getTeams() {
        try {
            List<String> teams = leagueService.getTeams();
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
            List<StandingsDTO> standings = leagueService.getStandings();
            LOG.info("Retrieved standings");
            return new ResponseEntity<>(standings, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/rosters", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getRosterByTeam(@RequestParam String team) {
        try {
            List<String> roster = leagueService.getRosterByTeam(team);
            LOG.info("Retrieved roster of {}", team);
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
            List<Integer> weeks = leagueService.getWeeks();
            LOG.info("Retrieved weeks of the season");
            return new ResponseEntity<>(weeks, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/schedule", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleDTO>> getSchedule(@RequestParam(required = false) Integer week) {
        try {
            List<Integer> weeks = leagueService.getWeeks();
            int minWeek = weeks.get(0);
            int maxWeek = weeks.get(weeks.size() - 1);
            if (week == null) {
                List<ScheduleDTO> schedule = leagueService.getFullSchedule();
                LOG.info("Retrieved full schedule");
                return new ResponseEntity<>(schedule, HttpStatus.OK);
            } else if (week < minWeek || week > maxWeek) {
                LOG.error("Bad week given");
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
            } else {
                List<ScheduleDTO> weeklySchedule = leagueService.getWeeklySchedule(week);
                LOG.info("Retrieved schedule for week {}", week);
                return new ResponseEntity<>(weeklySchedule, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/schedule/{teamName}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleDTO>> getScheduleForTeam(@PathVariable("teamName") String teamName,
                                                                @RequestParam(required = false) Integer week) {
        try {
            List<Integer> weeks = leagueService.getWeeks();
            int minWeek = weeks.get(0);
            int maxWeek = weeks.get(weeks.size() - 1);
            if (week == null) {
                List<ScheduleDTO> schedule = leagueService.getFullScheduleForTeam(teamName);
                LOG.info("Retrieved schedule for {}", teamName);
                return new ResponseEntity<>(schedule, HttpStatus.OK);
            } else if (week < minWeek || week > maxWeek) {
                LOG.info("Bad week given");
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
            } else {
                List<ScheduleDTO> weeklySchedule = leagueService.getWeeklyScheduleForTeam(week, teamName);
                LOG.info("Retrieved schedule for {}, week {}", teamName, week);
                return new ResponseEntity<>(weeklySchedule, HttpStatus.OK);
            }
        } catch (LeagueException e) {
            LOG.error("An error occurred fetching schedule for the given team name", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
