package com.argentstew.simulator.battle.web.servlet;

import com.argentstew.simulator.battle.web.model.SimulationResult;
import com.argentstew.simulator.battle.web.service.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController()
public class SimulatorServlet {

    private final SimulatorService simulatorService;

    @Autowired
    public SimulatorServlet(SimulatorService simulatorService) {
        this.simulatorService = simulatorService;
    }

    @GetMapping(path = "/simulation", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<SimulationResult> getSimulation(@RequestParam String fighter1, @RequestParam String fighter2) {
        SimulationResult result = new SimulationResult();
        if (fighter1 == null || fighter2 == null) {
            result.setMessage("Missing parameter. Please provide fighter1 and fighter2.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else if (fighter1.equals(fighter2)) {
            result.setMessage("Invalid mirror match selected. Please select different fighters.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        try {
            result = simulatorService.run(fighter1, fighter2);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
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
            return new ResponseEntity<>("Bad ID found", HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/fighters", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getFighters() {
        return new ResponseEntity<>(simulatorService.getFighters(), HttpStatus.OK);
    }
}
