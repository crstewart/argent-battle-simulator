package com.argentstew.simulator.battle.web.persistence;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * com.argentstew.simulator.battle.web.persistence
 * 1/3/2022
 *
 * @author argen
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "BLOG_ENTRIES")
public class BlogEntry {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog-id")
    @SequenceGenerator(name = "blog-id", sequenceName = "blog_entries_seq")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
