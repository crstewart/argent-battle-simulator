package com.argentstew.simulator.battle.web.persistence;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * com.argentstew.simulator.battle.web.persistence
 * 12/10/2021
 *
 * @author argen
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "LEAGUE_TEAMS")
public class Team {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "team-uuid")
    @GenericGenerator(name = "team-uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "division", referencedColumnName = "id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "id")
    private List<TeamFighter> fighters;
}
