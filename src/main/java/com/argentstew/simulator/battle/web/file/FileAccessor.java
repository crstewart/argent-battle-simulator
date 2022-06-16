package com.argentstew.simulator.battle.web.file;

import com.argentstew.simulator.battle.web.model.ImageDTO;

import java.io.InputStream;

/**
 * com.argentstew.simulator.battle.web.file
 * 12/21/2021
 *
 * @author argen
 */
public interface FileAccessor {

    ImageDTO getImage(String directory, String name);

    String getBlogEntry(String directory, int entryNumber);

    String getLogFile(String directory, String id);
}
