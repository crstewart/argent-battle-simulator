package com.argentstew.simulator.battle.web.model;

import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * com.argentstew.simulator.battle.web.model
 * 12/21/2021
 *
 * @author argen
 */
public enum ImageType {

    JPG(new HashSet<>(Arrays.asList("jpg", "jpeg")), MediaType.IMAGE_JPEG),
    PNG(Collections.singleton("png"), MediaType.IMAGE_PNG),
    GIF(Collections.singleton("gif"), MediaType.IMAGE_GIF);

    private final Set<String> extensions;
    private final MediaType mediaType;

    ImageType(Set<String> extensions, MediaType mediaType) {
        this.extensions = extensions;
        this.mediaType = mediaType;
    }

    public static Set<String> getAllExtensions() {
        return Arrays.stream(values()).flatMap(imageType -> imageType.extensions.stream()).collect(Collectors.toSet());
    }

    public static ImageType forExtension(String extension) {
        return Arrays.stream(values()).filter(imageType -> imageType.extensions.contains(extension)).findFirst()
                .orElse(null);
    }

    public MediaType getMediaType() {
        return mediaType;
    }
}
