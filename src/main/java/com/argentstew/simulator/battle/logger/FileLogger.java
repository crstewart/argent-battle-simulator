package com.argentstew.simulator.battle.logger;

import com.argentstew.simulator.battle.fighter.Fighter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * com.argentstew.simulator.battle.logger
 * 4/11/2020
 *
 * @author argen
 */
public class FileLogger implements BattleLogger {

    private String fileDir;
    private FileWriter fileWriter;

    public FileLogger() throws IOException {
        this("abs.properties");
    }

    public FileLogger(String filename) throws IOException {
        Properties properties = new Properties();
        if (new File(filename).exists()) {
            properties.load(new FileInputStream(filename));
        }
        this.fileDir = properties.getProperty("file.dir", ".");
        if (!this.fileDir.endsWith(File.separator)) {
            this.fileDir += File.separator;
        }
    }

    public void open(Fighter fighter1, Fighter fighter2) throws IOException {
        String fighter1Name = fighter1.getName().replaceAll("\\s+", "_")
                .replaceAll("&", "and");
        String fighter2Name = fighter2.getName().replaceAll("\\s+", "_")
                .replaceAll("&", "and");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String filename = fileDir + dateFormat.format(calendar.getTime()) + "_" + fighter1Name + "_vs_" +
                fighter2Name + ".txt";
        this.fileWriter = new FileWriter(filename);
    }

    public void close() throws IOException {
        if (this.fileWriter != null) {
            this.fileWriter.close();
        }
    }

    @Override
    public void log(String logMessage) {
        if (this.fileWriter == null) {
            throw new RuntimeException("File logger not open!");
        }

        try {
            this.fileWriter.write(logMessage + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(logMessage);
    }

    @Override
    public void log(Object object) {
        if (this.fileWriter == null) {
            throw new RuntimeException("File logger not open!");
        }

        try {
            this.fileWriter.write(object.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(object);
    }

    @Override
    public void debug(String logMessage) {
        // no-op
    }
}
