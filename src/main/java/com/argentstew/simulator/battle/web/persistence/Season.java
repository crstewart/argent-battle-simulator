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
@Table(name = "SEASON")
public class Season {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "season-uuid")
    @GenericGenerator(name = "season-uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "name")
    private String name;
}
