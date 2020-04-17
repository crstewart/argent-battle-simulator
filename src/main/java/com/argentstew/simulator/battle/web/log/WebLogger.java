package com.argentstew.simulator.battle.web.log;

import com.argentstew.simulator.battle.logger.BattleLogger;

import java.io.*;
import java.util.Properties;
import java.util.UUID;

/**
 * com.argentstew.simulator.battle.web.logger
 * 4/16/2020
 *
 * @author argen
 */
public class WebLogger implements BattleLogger {

    private String fileDir;
    private String uuid;
    private FileWriter fileWriter;
    private StringWriter stringWriter;

    public WebLogger(StringWriter stringWriter) throws IOException {
        this.uuid = UUID.randomUUID().toString();
        this.stringWriter = stringWriter;

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

    public String getUuid() {
        return this.uuid;
    }

    public void open() throws IOException {
        String filename = fileDir + uuid + ".txt";
        this.fileWriter = new FileWriter(filename);
    }

    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }

    @Override
    public void log(String logMessage) {
        if (this.fileWriter == null) {
            throw new RuntimeException("File logger not open!");
        }

        try {
            fileWriter.write(logMessage + "\n");
            stringWriter.write(logMessage + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void log(Object object) {
        if (this.fileWriter == null) {
            throw new RuntimeException("File logger not open!");
        }

        try {
            fileWriter.write(object.toString() + "\n");
            stringWriter.write(object.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void debug(String logMessage) {
        // no-op
    }
}
