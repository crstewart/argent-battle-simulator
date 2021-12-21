package com.argentstew.simulator.battle.web.persistence;

import lombok.*;

import javax.persistence.*;

/**
 * com.argentstew.simulator.battle.web.persistence
 * 12/10/2021
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
@Table(name = "FIGHTERS")
public class Fighter {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fighter-id")
    @SequenceGenerator(name = "fighter-id", sequenceName = "fighters_seq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "series_of_origin")
    private String seriesOfOrigin;

    @Column(name = "copyright_owner")
    private String copyrightOwner;
}
