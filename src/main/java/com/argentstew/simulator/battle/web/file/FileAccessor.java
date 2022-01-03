package com.argentstew.simulator.battle.web.file;

import com.argentstew.simulator.battle.web.model.BlogDTO;
import com.argentstew.simulator.battle.web.model.ImageDTO;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.file
 * 12/21/2021
 *
 * @author argen
 */
public interface FileAccessor {

    ImageDTO getImage(String directory, String name);

    List<BlogDTO> getAllBlogTitles(String directory);

    BlogDTO getBlogEntry(String directory, int entryNumber);
}
