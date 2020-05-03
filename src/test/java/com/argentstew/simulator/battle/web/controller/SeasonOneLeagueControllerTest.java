package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.config.TestConfig;
import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.service.SeasonOneLeagueService;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
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
    private SeasonOneLeagueService service;

    @Test
    void getTeams_Success() throws Exception {
        when(service.getTeams()).thenReturn(Arrays.asList("Fighter1", "Fighter2", "Fighter3"));
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
        when(service.getTeams()).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/teams"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getStandings_Success() throws Exception {
        when(service.getStandings()).thenReturn(Collections.singletonList(new StandingsDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/standings"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getStandings_Exception() throws Exception {
        when(service.getStandings()).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/standings"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getRosters_Success() throws Exception {
        when(service.getRosterByTeam("team1")).thenReturn(Collections.singletonList("Fighter1"));
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/rosters?team=team1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String returnValue = result.getResponse().getContentAsString();
        assertTrue(returnValue.contains("Fighter1"));
    }

    @Test
    void getRosters_BadTeamName() throws Exception {
        when(service.getRosterByTeam("team1")).thenThrow(LeagueException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/rosters?team=team1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getRosters_Exception() throws Exception {
        when(service.getRosterByTeam("team1")).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/rosters?team=team1"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getWeeks_Success() throws Exception {
        when(service.getWeeks()).thenReturn(Collections.singletonList(1));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/weeks"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getWeeks_Exception() throws Exception {
        when(service.getWeeks()).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/weeks"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getSchedule_FullSchedule() throws Exception {
        when(service.getWeeks()).thenReturn(Arrays.asList(1, 2, 3));
        when(service.getFullSchedule()).thenReturn(Collections.singletonList(new ScheduleDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getSchedule_WeeklySchedule() throws Exception {
        when(service.getWeeks()).thenReturn(Arrays.asList(1, 2, 3));
        when(service.getWeeklySchedule(1)).thenReturn(Collections.singletonList(new ScheduleDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule?week=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getSchedule_BadWeek() throws Exception {
        when(service.getWeeks()).thenReturn(Arrays.asList(1, 2, 3));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule?week=4"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getSchedule_Exception() throws Exception {
        when(service.getFullSchedule()).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void getScheduleForTeam_FullSchedule() throws Exception {
        when(service.getWeeks()).thenReturn(Arrays.asList(1, 2, 3));
        when(service.getFullScheduleForTeam("team1")).thenReturn(Collections.singletonList(new ScheduleDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getScheduleForTeam_WeeklySchedule() throws Exception {
        when(service.getWeeks()).thenReturn(Arrays.asList(1, 2, 3));
        when(service.getWeeklyScheduleForTeam(1, "team1"))
                .thenReturn(Collections.singletonList(new ScheduleDTO()));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1?week=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getScheduleForTeam_BadWeek() throws Exception {
        when(service.getWeeks()).thenReturn(Arrays.asList(1, 2, 3));
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1?week=4"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getScheduleForTeam_BadTeam() throws Exception {
        when(service.getWeeks()).thenReturn(Arrays.asList(1, 2, 3));
        when(service.getFullScheduleForTeam("team1")).thenThrow(LeagueException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getScheduleForTeam_Exception() throws Exception {
        when(service.getFullScheduleForTeam("team1")).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/seasons/1/schedule/team1"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
