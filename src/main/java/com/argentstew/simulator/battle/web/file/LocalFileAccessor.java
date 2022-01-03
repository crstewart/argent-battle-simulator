package com.argentstew.simulator.battle.web.file;

import com.argentstew.simulator.battle.web.model.BlogDTO;
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
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<BlogDTO> getAllBlogTitles(String directory) {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            try {
                List<Path> htmlPaths = Files.list(Paths.get(dir.getAbsolutePath()))
                        .sorted((a, b) -> Comparator.<Long>naturalOrder().compare(a.toFile().lastModified(),
                                b.toFile().lastModified()))
                        .filter(path -> path.getFileName().endsWith(".html"))
                        .collect(Collectors.toList());
                List<BlogDTO> dtos = new ArrayList<>(htmlPaths.size());
                for (int i = 0; i < htmlPaths.size(); i++) {
                    dtos.add(BlogDTO.builder()
                            .number(i + 1)
                            .title(htmlPaths.get(i).getFileName().toString())
                            .timestamp(LocalDateTime.ofEpochSecond(htmlPaths.get(i).toFile().lastModified(),
                                    0, ZoneOffset.UTC))
                            .build());
                }

                return dtos;
            } catch (IOException e) {
                log.error("Blog entry files could not be read from directory '{}'", directory, e);
            }
        }

        return Collections.emptyList();
    }

    @Override
    public BlogDTO getBlogEntry(String directory, int entryNumber) {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            try {
                List<Path> htmlPaths = Files.list(Paths.get(dir.getAbsolutePath()))
                        .sorted((a, b) -> Comparator.<Long>naturalOrder().compare(a.toFile().lastModified(),
                                b.toFile().lastModified()))
                        .filter(path -> path.getFileName().endsWith(".html"))
                        .collect(Collectors.toList());

                int index = entryNumber - 1;
                return BlogDTO.builder()
                        .number(entryNumber)
                        .title(htmlPaths.get(entryNumber).getFileName().toString())
                        .html(new String(Files.readAllBytes(htmlPaths.get(index))))
                        .timestamp(LocalDateTime.ofEpochSecond(htmlPaths.get(index).toFile().lastModified(),
                                0, ZoneOffset.UTC))
                        .build();
            } catch (IOException e) {
                log.error("Blog entry number '{}' could not be read", entryNumber, e);
            }
        }

        return null;
    }
}
