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
public class LogFetcher {

    private String fileDir;
    private String uuid;

    public LogFetcher(String uuid) throws IOException {
        this.uuid = uuid;

        String filename = "abs.properties";
        Properties properties = new Properties();
        if (new File(filename).exists()) {
            properties.load(new FileInputStream(filename));
        }
        this.fileDir = properties.getProperty("file.dir", ".");
        if (!this.fileDir.endsWith(File.separator)) {
            this.fileDir += File.separator;
        }
    }

    public String getFile() throws IOException {
        String filename = fileDir + uuid + ".txt";
        byte[] fileBytes = Files.readAllBytes(Paths.get(filename));
        return new String(fileBytes);
    }
}
