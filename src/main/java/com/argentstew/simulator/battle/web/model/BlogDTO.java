package com.argentstew.simulator.battle.web.model;

import com.argentstew.simulator.battle.web.persistence.BlogEntry;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;
import java.util.Date;

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

    private String description;

    @JsonFormat(pattern = "MMMM d, yyyy", timezone = "UTC")
    private Date timestamp;

    public static BlogDTO from(BlogEntry blogEntry) {
        return BlogDTO.builder().number(blogEntry.getId()).title(blogEntry.getTitle())
                .description(blogEntry.getDescription())
                .timestamp(Date.from(blogEntry.getTimestamp().toInstant(ZoneOffset.UTC)))
                .build();
    }
}
