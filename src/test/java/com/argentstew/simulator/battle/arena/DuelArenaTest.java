package com.argentstew.simulator.battle.arena;

import com.argentstew.simulator.battle.fighter.Fighter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * com.argentstew.simulator.battle.arena
 * 4/24/2020
 *
 * @author argen
 */
public class DuelArenaTest {

    private Fighter fighter1;
    private Fighter fighter2;

    private DuelArena arena;

    @BeforeEach
    void setUp() {
        fighter1 = Fighter.builder().name("Fighter 1").build();
        fighter2 = Fighter.builder().name("Fighter 2").build();
        arena = new DuelArena();
        arena.setLeftFighter(fighter1);
        arena.setRightFighter(fighter2);
    }

    @Test
    void testGetDistanceBetweenFighters() {
        assertEquals(2.0, arena.getDistanceBetweenFighters(), 0.01);
        arena.setFighterPosition(fighter1, 3);
        assertEquals(1.0, arena.getDistanceBetweenFighters(), 0.01);
        arena.setFighterPosition(fighter1, 1);
        assertEquals(3.0, arena.getDistanceBetweenFighters(), 0.01);
    }

    @Test
    void testCanAdvance() {
        assertFalse(arena.canAdvance(null));
        assertTrue(arena.canAdvance(fighter1));
        assertTrue(arena.canAdvance(fighter2));

        arena.setFighterPosition(fighter1, 3);
        assertFalse(arena.canAdvance(fighter1));
        assertFalse(arena.canAdvance(fighter2));

        arena.setFighterPosition(fighter1, 4);
        assertFalse(arena.canAdvance(fighter1));

        arena.setFighterPosition(fighter2, 2);
        assertFalse(arena.canAdvance(fighter2));
    }

    @Test
    void testCanRetreat() {
        assertFalse(arena.canRetreat(null));
        assertTrue(arena.canRetreat(fighter1));
        assertTrue(arena.canRetreat(fighter2));

        arena.setFighterPosition(fighter1, 1);
        assertFalse(arena.canRetreat(fighter1));

        arena.setFighterPosition(fighter2, 5);
        assertFalse(arena.canRetreat(fighter2));
    }

    @Test
    void testAdvance() {
        arena.advance(fighter1);
        assertEquals(3, arena.getFighterPosition(fighter1).getX());

        arena.advance(fighter2);
        assertEquals(3, arena.getFighterPosition(fighter2).getX());
    }

    @Test
    void testRetreat() {
        arena.retreat(fighter1);
        assertEquals(1, arena.getFighterPosition(fighter1).getX());

        arena.retreat(fighter2);
        assertEquals(5, arena.getFighterPosition(fighter2).getX());
    }

    @Test
    void testFullAdvance() {
        arena.setFighterPosition(fighter1, 1);
        arena.fullAdvance(fighter1);
        assertEquals(3, arena.getFighterPosition(fighter1).getX());

        arena.setFighterPosition(fighter1, 1);
        arena.setFighterPosition(fighter2, 5);
        arena.fullAdvance(fighter2);
        assertEquals(2, arena.getFighterPosition(fighter2).getX());
    }

    @Test
    void testFullRetreat() {
        arena.setFighterPosition(fighter1, 5);
        arena.fullRetreat(fighter1);
        assertEquals(1, arena.getFighterPosition(fighter1).getX());

        arena.setFighterPosition(fighter2, 1);
        arena.fullRetreat(fighter2);
        assertEquals(5, arena.getFighterPosition(fighter2).getX());
    }
}
