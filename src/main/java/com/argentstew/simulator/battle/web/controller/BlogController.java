package com.argentstew.simulator.battle.web.controller;

import com.argentstew.simulator.battle.web.exception.ImageTypeNotRecognizedException;
import com.argentstew.simulator.battle.web.exception.MissingBlogException;
import com.argentstew.simulator.battle.web.model.BlogDTO;
import com.argentstew.simulator.battle.web.model.ImageDTO;
import com.argentstew.simulator.battle.web.model.ImageType;
import com.argentstew.simulator.battle.web.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * com.argentstew.simulator.battle.web.controller
 * 1/3/2022
 *
 * @author argen
 */
@RestController
@RequestMapping("/v1/blogs")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BlogDTO>> getBlogEntryCatalog() {
        try {
            return ResponseEntity.ok(blogService.getEntryCatalog());
        } catch (MissingBlogException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/{number}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogDTO> getBlogEntry(@PathVariable int number) {
        try {
            return ResponseEntity.ok(blogService.getEntry(number));
        } catch (MissingBlogException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/{image}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> getBlogImage(@PathVariable String image) {
        try {
            ImageDTO imageDTO = blogService.getBlogImage(image);

            HttpHeaders headers = new HttpHeaders();
            ImageType imageType = ImageType.forExtension(imageDTO.getExtension());
            if (imageType == null) {
                throw new ImageTypeNotRecognizedException("Image type not recognized: " + imageDTO.getExtension());
            }
            headers.setContentType(imageType.getMediaType());

            return new ResponseEntity<>(imageDTO.getBytes(), headers, HttpStatus.OK);
        } catch (MissingBlogException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
