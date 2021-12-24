package com.argentstew.simulator.battle.web.cache;

import com.argentstew.simulator.battle.web.model.ImageDTO;

/**
 * com.argentstew.simulator.battle.web.cache
 * 12/20/2021
 *
 * @author argen
 */
public interface ImageCache {

    ImageDTO get(String name);

    void put(ImageDTO dto);
}
