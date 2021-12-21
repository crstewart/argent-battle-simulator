package com.argentstew.simulator.battle.web.cache;

import com.argentstew.simulator.battle.web.model.ImageDTO;
import com.argentstew.simulator.battle.web.model.ImageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * com.argentstew.simulator.battle.web.cache
 * 12/20/2021
 *
 * @author argen
 */
@Component
public class FighterImageCache implements ImageCache {

    private static final Logger log = LogManager.getLogger(FighterImageCache.class);

    private final File directory;
    private final boolean active;

    @Autowired
    public FighterImageCache() {
        this.directory = new File(System.getenv("IMAGE_CACHE_LOCATION"));
        this.active = (!this.directory.exists() && this.directory.mkdir()) || this.directory.isDirectory();
    }

    @Override
    public ImageDTO get(String name) {
        byte[] data = null;
        String extension = null;
        if (active) {
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
        } else {
            log.warn("Image cache not properly configured; please check FS location '{}'",
                    directory.getAbsolutePath());
        }

        if (data == null) {
            return null;
        }

        return ImageDTO.builder().name(name).extension(extension).bytes(data).build();
    }

    @Override
    public void put(ImageDTO dto) {
        String fileName = dto.getName() + "." + dto.getExtension();
        if (active) {
            try {
                File file = new File(directory, fileName);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                Path path = Paths.get(file.getAbsolutePath());
                Files.write(path, dto.getBytes());
            } catch (IOException e) {
                log.error("Image cache could not write file '{}'", fileName, e);
            }
        } else {
            log.warn("Image cache not properly configured; please check FS location '{}'",
                    directory.getAbsolutePath());
        }
    }
}