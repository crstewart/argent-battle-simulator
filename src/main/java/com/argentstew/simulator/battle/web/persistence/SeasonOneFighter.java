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
@Table(name = "Season_1_Fighters")
public class SeasonOneFighter {

    @Id
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "id")
    private SeasonOneTeam team;
}
