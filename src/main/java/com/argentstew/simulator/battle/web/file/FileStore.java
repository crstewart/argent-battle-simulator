package com.argentstew.simulator.battle.web.file;

import java.io.InputStream;

/**
 * com.argentstew.simulator.battle.web.file
 * 6/4/2022
 *
 * @author argen
 */
public interface FileStore {

    boolean saveFile(String directory, String filename, InputStream contents);

    boolean saveFile(String directory, String filename, InputStream contents, boolean overwrite);
}
