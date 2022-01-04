package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.model.BlogDTO;
import com.argentstew.simulator.battle.web.model.ImageDTO;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 1/2/2022
 *
 * @author argen
 */
public interface BlogService {

    List<BlogDTO> getEntryCatalog();

    String getEntry(int entryNumber);

    void reloadEntryCatalog();

    ImageDTO getBlogImage(String image);
}
