package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.config.TestConfig;
import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.service.LeagueService;
import com.argentstew.simulator.battle.web.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * com.argentstew.simulator.battle.web.controller
 * 5/3/2020
 *
 * @author argen
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(SeasonOneLeagueController.class)
@ContextConfiguration(classes = {TestConfig.class})
public class SeasonOneLeagueControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;

    @Test
    void getTeams_Success() throws Exception {
        when(leagueService.getTeamsBySeason(anyString())).thenReturn(Arrays.asList("Fighter1", "Fighter2", "Fighter3"));
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/teams"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String returnValue = result.getResponse().getContentAsString();
        assertTrue(returnValue.contains("Fighter1"));
        assertTrue(returnValue.contains("Fighter2"));
        assertTrue(returnValue.contains("Fighter3"));
    }

    @Test
    void getTeams_Exception() throws Exception {
        when(leagueService.getTeamsBySeason(anyString())).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/teams"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getStandings_Success() throws Exception {
        when(leagueService.getStandings(anyString())).thenReturn(Collections.singletonList(new StandingsDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/standings"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getStandings_Exception() throws Exception {
        when(leagueService.getStandings(anyString())).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/standings"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getRosters_Success() throws Exception {
        UUID testId = UUID.randomUUID();
        when(leagueService.getRosterByTeam(testId.toString())).thenReturn(Collections.singletonList("Fighter1"));
        when(teamService.getTeamId(anyString(), eq("team1"))).thenReturn(testId);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/rosters?team=team1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String returnValue = result.getResponse().getContentAsString();
        assertTrue(returnValue.contains("Fighter1"));
    }

    @Test
    void getRosters_BadTeamName() throws Exception {
        when(teamService.getTeamId(anyString(), eq("team1"))).thenThrow(LeagueException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/rosters?team=team1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getRosters_Exception() throws Exception {
        UUID testId = UUID.randomUUID();
        when(leagueService.getRosterByTeam(testId.toString())).thenThrow(RuntimeException.class);
        when(teamService.getTeamId(anyString(), eq("team1"))).thenReturn(testId);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/rosters?team=team1"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getWeeks_Success() throws Exception {
        when(leagueService.getWeeks(anyString())).thenReturn(Collections.singletonList(1));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/weeks"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getWeeks_Exception() throws Exception {
        when(leagueService.getWeeks(anyString())).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/weeks"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getSchedule_FullSchedule() throws Exception {
        when(leagueService.getWeeks(anyString())).thenReturn(Arrays.asList(1, 2, 3));
        when(leagueService.getFullScheduleForSeason(anyString()))
                .thenReturn(Collections.singletonList(new ScheduleDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getSchedule_WeeklySchedule() throws Exception {
        when(leagueService.getWeeks(anyString())).thenReturn(Arrays.asList(1, 2, 3));
        when(leagueService.getWeeklyScheduleForSeason(anyString(), eq(1)))
                .thenReturn(Collections.singletonList(new ScheduleDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule?week=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getSchedule_BadWeek() throws Exception {
        when(leagueService.getWeeks(anyString())).thenReturn(Arrays.asList(1, 2, 3));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule?week=4"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getSchedule_Exception() throws Exception {
        when(leagueService.getFullScheduleForSeason(anyString())).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getScheduleForTeam_FullSchedule() throws Exception {
        UUID testId = UUID.randomUUID();
        when(leagueService.getWeeks(anyString())).thenReturn(Arrays.asList(1, 2, 3));
        when(leagueService.getFullScheduleForTeam(testId.toString()))
                .thenReturn(Collections.singletonList(new ScheduleDTO()));
        when(teamService.getTeamId(anyString(), eq("team1"))).thenReturn(testId);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getScheduleForTeam_WeeklySchedule() throws Exception {
        UUID testId = UUID.randomUUID();
        when(leagueService.getWeeks(anyString())).thenReturn(Arrays.asList(1, 2, 3));
        when(leagueService.getWeeklyScheduleForTeam(testId.toString(), 1))
                .thenReturn(Collections.singletonList(new ScheduleDTO()));
        when(teamService.getTeamId(anyString(), eq("team1"))).thenReturn(testId);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1?week=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getScheduleForTeam_BadWeek() throws Exception {
        UUID testId = UUID.randomUUID();
        when(leagueService.getWeeks(anyString())).thenReturn(Arrays.asList(1, 2, 3));
        when(teamService.getTeamId(anyString(), eq("team1"))).thenReturn(testId);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1?week=4"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getScheduleForTeam_BadTeam() throws Exception {
        when(teamService.getTeamId(anyString(), eq("team1"))).thenThrow(LeagueException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getScheduleForTeam_Exception() throws Exception {
        when(leagueService.getFullScheduleForTeam("team1")).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
