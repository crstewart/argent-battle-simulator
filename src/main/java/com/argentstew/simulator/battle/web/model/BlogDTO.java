package com.argentstew.simulator.battle.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * com.argentstew.simulator.battle.web.model
 * 1/2/2022
 *
 * @author argen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {

    private Integer number;
    private String title;
    private LocalDateTime timestamp;
    private String html;
}
