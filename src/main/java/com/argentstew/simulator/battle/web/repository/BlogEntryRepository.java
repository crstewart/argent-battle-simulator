package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.BlogEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.repository
 * 1/3/2022
 *
 * @author argen
 */
public interface BlogEntryRepository extends CrudRepository<BlogEntry, Integer> {

    List<BlogEntry> findAllByOrderById();
}
