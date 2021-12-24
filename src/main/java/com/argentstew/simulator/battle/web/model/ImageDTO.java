package com.argentstew.simulator.battle.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * com.argentstew.simulator.battle.web.model
 * 12/20/2020
 *
 * @author argen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {

    private String name;
    private String extension;
    private byte[] bytes;
}
