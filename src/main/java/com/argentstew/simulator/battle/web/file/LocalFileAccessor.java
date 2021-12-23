package com.argentstew.simulator.battle.web.file;

import com.argentstew.simulator.battle.web.model.ImageDTO;
import com.argentstew.simulator.battle.web.model.ImageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * com.argentstew.simulator.battle.web.file
 * 12/22/2021
 *
 * @author argen
 */
@Component
@Profile("dev")
public class LocalFileAccessor implements FileAccessor {

    private static final Logger log = LogManager.getLogger(LocalFileAccessor.class);

    @Override
    public ImageDTO getImage(String directory, String name) {
        byte[] data = null;
        String extension = null;
        for (String possibleExtension : ImageType.getAllExtensions()) {
            String fileName = name + "." + possibleExtension;
            try {
                File file = new File(directory, fileName);
                if (file.exists()) {
                    Path path = Paths.get(file.getAbsolutePath());
                    data = Files.readAllBytes(path);
                    extension = possibleExtension;
                    break;
                }
            } catch (IOException e) {
                log.error("Image cache could not read file '{}'", fileName);
            }
        }

        if (data == null) {
            return null;
        }

        return ImageDTO.builder().name(name).extension(extension).bytes(data).build();
    }
}
