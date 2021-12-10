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
@Table(name = "LEAGUE_SEASON_WEEKS")
public class Week {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "week-uuid")
    @GenericGenerator(name = "week-uuid", strategy = "uuid2")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season", referencedColumnName = "id")
    private Season season;

    @Column(name = "number")
    private Integer number;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}
