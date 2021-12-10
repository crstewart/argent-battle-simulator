package com.argentstew.simulator.battle.web.persistence;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
@Table(name = "LEAGUE_TEAM_FIGHTERS")
public class TeamFighter {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tf-uuid")
    @GenericGenerator(name = "tf-uuid", strategy = "uuid2")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "id")
    private Team team;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fighter", referencedColumnName = "id")
    private Fighter fighter;
}
