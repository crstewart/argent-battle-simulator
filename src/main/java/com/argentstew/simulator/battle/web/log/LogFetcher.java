package com.argentstew.simulator.battle.web.log;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;

/**
 * com.argentstew.simulator.battle.web
 * 4/16/2020
 *
 * @author argen
 */
@Component
public class LogFetcher {

    private String fileDir;

    public String getFile(String uuid) throws IOException {
        if (fileDir == null) {
            String filename = "abs.properties";
            Properties properties = new Properties();
            if (Files.exists(Paths.get(filename))) {
                properties.load(new FileInputStream(filename));
            }
            fileDir = properties.getProperty("file.dir", ".");
            if (!fileDir.endsWith(File.separator)) {
                fileDir += File.separator;
            }
        }

        String filename = fileDir + uuid + ".txt";
        byte[] fileBytes = Files.readAllBytes(Paths.get(filename));
        return new String(fileBytes);
    }
}
