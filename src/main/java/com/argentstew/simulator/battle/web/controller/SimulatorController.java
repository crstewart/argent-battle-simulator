package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.web.model.FighterDTO;
import com.argentstew.simulator.battle.web.model.SimulationResult;
import com.argentstew.simulator.battle.web.service.FighterService;
import com.argentstew.simulator.battle.web.service.SimulatorService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.*;

/**
 * com.argentstew.simulator.battle.web.servlet
 * 4/16/2020
 *
 * @author argen
 */
@RestController
@RequestMapping("/v1")
public class SimulatorController {

    private static final Logger LOG = LogManager.getLogger(SimulatorController.class);

    private final SimulatorService simulatorService;
    private final FighterService fighterService;

    @Autowired
    public SimulatorController(SimulatorService simulatorService, FighterService fighterService) {
        this.simulatorService = simulatorService;
        this.fighterService = fighterService;
    }

    @GetMapping(path = "/simulation", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<SimulationResult> getSimulation(@RequestParam String fighter1, @RequestParam String fighter2) {
        SimulationResult result = new SimulationResult();
        if (StringUtils.isBlank(fighter1) || StringUtils.isBlank(fighter2)) {
            LOG.error("Missing parameter. Fighter 1 = {}, Fighter 2 = {}", fighter1, fighter2);
            result.setMessage("Missing parameter. Please provide fighter1 and fighter2.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else if (fighter1.equals(fighter2)) {
            LOG.error("Mirror match detected.");
            result.setMessage("Invalid mirror match selected. Please select different fighters.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        try {
            result = simulatorService.run(fighter1, fighter2);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred", e);
            result.setMessage("An error occurred during the simulation. Please contact the administrator.");
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/files/{id}.txt", produces = APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> getFile(@PathVariable("id") String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return new ResponseEntity<>(simulatorService.fetchSimulation(uuid.toString()), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            LOG.error("Bad ID", e);
            return new ResponseEntity<>("Bad ID found", HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            LOG.error("Missing file", e);
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/fighters", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getFighters() {
        try {
            return new ResponseEntity<>(fighterService.getFighters(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred. Please contact the administrator.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/fighters/{name}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FighterDTO> getFighterByName(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<>(fighterService.getFighter(name), HttpStatus.OK);
        } catch (IllegalStateException e) {
            LOG.error("Could not fetch requested fighter", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOG.error("Unknown error occurred. Please contact the administrator.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
