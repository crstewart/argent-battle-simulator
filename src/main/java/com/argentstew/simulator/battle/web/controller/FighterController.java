package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.web.exception.ImageTypeNotRecognizedException;
import com.argentstew.simulator.battle.web.model.FighterDTO;
import com.argentstew.simulator.battle.web.model.ImageDTO;
import com.argentstew.simulator.battle.web.model.ImageType;
import com.argentstew.simulator.battle.web.service.FighterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * com.argentstew.simulator.battle.web.servlet
 * 4/16/2020
 *
 * @author argen
 */
@RestController
@RequestMapping("/v1/fighters")
public class FighterController {

    private static final Logger LOG = LogManager.getLogger(FighterController.class);

    private final FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllFighters() {
        try {
            return new ResponseEntity<>(fighterService.getFighters(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Unknown error occurred. Please contact the administrator.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{name}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FighterDTO> getFighter(@PathVariable("name") String name) {
        try {
            String fighterName = name.trim().replaceAll("_and_", " & ")
                    .replaceAll("_", " ");
            return new ResponseEntity<>(fighterService.getFighter(fighterName), HttpStatus.OK);
        } catch (IllegalStateException e) {
            LOG.error("Could not fetch requested fighter", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOG.error("Unknown error occurred. Please contact the administrator.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{name}/image")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> getFighterImage(@PathVariable String name) {
        try {
            String fighterName = name.trim().replaceAll("_and_", " & ")
                    .replaceAll("_", " ");
            ImageDTO fighterImage = fighterService.getFighterImage(fighterName);

            HttpHeaders headers = new HttpHeaders();
            ImageType imageType = ImageType.forExtension(fighterImage.getExtension());
            if (imageType == null) {
                throw new ImageTypeNotRecognizedException("Image type not recognized: " + fighterImage.getExtension());
            }
            headers.setContentType(imageType.getMediaType());

            return new ResponseEntity<>(fighterImage.getBytes(), headers, HttpStatus.OK);
        } catch (IllegalStateException e) {
            LOG.error("Could not fetch requested fighter image", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOG.error("Unknown error occurred. Please contact the administrator.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
