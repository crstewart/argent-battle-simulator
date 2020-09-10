package com.argentstew.simulator.battle.web.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * com.argentstew.simulator.battle.web.persistence
 * 5/2/2020
 *
 * @author argen
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "Season_2_Divisions")
public class SeasonTwoDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "id")
    private SeasonTwoTeam team;
}
