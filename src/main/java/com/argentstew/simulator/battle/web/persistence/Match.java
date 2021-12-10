package com.argentstew.simulator.battle.web.persistence;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

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
@Table(name = "LEAGUE_SEASON_MATCHES")
public class Match {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "match-uuid")
    @GenericGenerator(name = "match-uuid", strategy = "uuid2")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season", referencedColumnName = "id")
    private Season season;

    @Column(name = "match_time")
    private LocalDateTime startDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    private Team homeTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_fighter", referencedColumnName = "id")
    private Fighter homeFighter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    private Team awayTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_fighter", referencedColumnName = "id")
    private Fighter awayFighter;

    @Column(name = "winner")
    private MatchStatus winner;
}
