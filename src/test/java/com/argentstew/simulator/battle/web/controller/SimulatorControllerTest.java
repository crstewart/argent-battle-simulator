package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.web.model.FighterDTO;
import com.argentstew.simulator.battle.web.model.SimulationResult;
import com.argentstew.simulator.battle.web.service.FighterService;
import com.argentstew.simulator.battle.web.service.SimulatorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * com.argentstew.simulator.battle.web.controller
 * 4/23/2020
 *
 * @author argen
 */
@WebMvcTest(SimulatorController.class)
public class SimulatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SimulatorService simulatorService;

    @MockBean
    private FighterService fighterService;

    @Test
    void testSimulation_Success() throws Exception {
        when(simulatorService.run(anyString(), anyString())).thenReturn(new SimulationResult());
        mvc.perform(MockMvcRequestBuilders.get("/v1/simulation?fighter1=f1&fighter2=f2"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testSimulation_BlankFighter() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v1/simulation?fighter1=&fighter2="))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testSimulation_MirrorMatch() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v1/simulation?fighter1=f1&fighter2=f1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testSimulation_ErrorInService() throws Exception {
        when(simulatorService.run(anyString(), anyString())).thenThrow(IOException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/simulation?fighter1=f1&fighter2=f2"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void testGetFile_Success() throws Exception {
        String uuid = UUID.randomUUID().toString();
        when(simulatorService.fetchSimulation(eq(uuid))).thenReturn("Hello, simulator!");
        mvc.perform(MockMvcRequestBuilders.get("/v1/files/" + uuid + ".txt"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, simulator!"));
    }

    @Test
    void testGetFile_BadUuid() throws Exception {
        String uuid = "a-b-c";
        mvc.perform(MockMvcRequestBuilders.get("/v1/files/" + uuid + ".txt"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testGetFile_FileNotFound() throws Exception {
        String uuid = UUID.randomUUID().toString();
        when(simulatorService.fetchSimulation(eq(uuid))).thenThrow(IOException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/files/" + uuid + ".txt"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testGetFighters_Success() throws Exception {
        when(fighterService.getFighters()).thenReturn(Collections.emptyList());
        mvc.perform(MockMvcRequestBuilders.get("/v1/fighters"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetFighters_Error() throws Exception {
        when(fighterService.getFighters()).thenThrow(IllegalStateException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/fighters"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void testGetFighterByName_Success() throws Exception {
        when(fighterService.getFighter(anyString())).thenReturn(new FighterDTO());
        mvc.perform(MockMvcRequestBuilders.get("/v1/fighters/f1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetFighterByName_FighterNotFound() throws Exception {
        when(fighterService.getFighter(anyString())).thenThrow(IllegalStateException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/fighters/f1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testGetFighterByName_UnknownError() throws Exception {
        when(fighterService.getFighter(anyString())).thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/v1/fighters/f1"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
