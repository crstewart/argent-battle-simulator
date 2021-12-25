package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.persistence.Team;
import com.argentstew.simulator.battle.web.service.LeagueService;
import com.argentstew.simulator.battle.web.service.TeamService;
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

    private static final String SEASON_ONE_ID = "e9359546-f8a7-410e-bddb-ed884600aa47";

    private final LeagueService leagueService;
    private final TeamService teamService;

    @Autowired
    public SeasonOneLeagueController(LeagueService leagueService,
                                     TeamService teamService) {
        this.leagueService = leagueService;
        this.teamService = teamService;
    }

    @GetMapping(path = "/teams", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getTeams() {
        try {
            List<String> teams = leagueService.getTeamsBySeason(SEASON_ONE_ID);
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
            List<StandingsDTO> standings = leagueService.getStandings(SEASON_ONE_ID);
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
            String teamName = team.trim().replaceAll("_and_", " & ")
                    .replaceAll("_", " ");
            List<String> roster = teamService.getRosterByTeam(SEASON_ONE_ID, teamName);
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
            List<Integer> weeks = leagueService.getWeeks(SEASON_ONE_ID);
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
            List<Integer> weeks = leagueService.getWeeks(SEASON_ONE_ID);
            int minWeek = weeks.get(0);
            int maxWeek = weeks.get(weeks.size() - 1);
            if (week == null) {
                List<ScheduleDTO> schedule = leagueService.getFullScheduleForSeason(SEASON_ONE_ID);
                LOG.info("Retrieved full schedule");
                return new ResponseEntity<>(schedule, HttpStatus.OK);
            } else if (week < minWeek || week > maxWeek) {
                LOG.error("Bad week given");
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
            } else {
                List<ScheduleDTO> weeklySchedule = leagueService.getWeeklyScheduleForSeason(SEASON_ONE_ID, week);
                LOG.info("Retrieved schedule for week {}", week);
                return new ResponseEntity<>(weeklySchedule, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/schedule/{team}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleDTO>> getScheduleForTeam(@PathVariable String team,
                                                                @RequestParam(required = false) Integer week) {
        try {
            String teamName = team.trim().replaceAll("_and_", " & ")
                    .replaceAll("_", " ");
            Team teamEntity = teamService.getTeam(SEASON_ONE_ID, teamName);
            List<Integer> weeks = leagueService.getWeeks(SEASON_ONE_ID);
            int minWeek = weeks.get(0);
            int maxWeek = weeks.get(weeks.size() - 1);
            if (week == null) {
                List<ScheduleDTO> schedule = leagueService.getFullScheduleForTeam(teamEntity);
                LOG.info("Retrieved schedule for {}", teamEntity);
                return new ResponseEntity<>(schedule, HttpStatus.OK);
            } else if (week < minWeek || week > maxWeek) {
                LOG.info("Bad week given");
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
            } else {
                List<ScheduleDTO> weeklySchedule = leagueService.getWeeklyScheduleForTeam(teamEntity, week);
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
