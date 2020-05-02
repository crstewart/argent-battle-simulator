package com.argentstew.simulator.battle.web.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * com.argentstew.simulator.battle.web.persistence
 * 5/2/2020
 *
 * @author argen
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "Season_1_Schedule_Matches")
public class SeasonOneMatch {

    @Id
    private int id;

    @Column(name = "match_date")
    private Date matchDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    private SeasonOneTeam homeTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    private SeasonOneTeam awayTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private SeasonOneTeam winner;
}
