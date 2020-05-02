package com.argentstew.simulator.battle.web.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "Season_1_Schedule_Weeks")
public class SeasonOneWeek {

    @Id
    private int number;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
}
