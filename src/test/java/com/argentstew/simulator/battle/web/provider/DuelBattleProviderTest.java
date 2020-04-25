package com.argentstew.simulator.battle.web.provider;

import com.argentstew.simulator.battle.Battle;
import com.argentstew.simulator.battle.DuelBattle;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.NoopBattleLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * com.argentstew.simulator.battle.web.provider
 * 4/24/2020
 *
 * @author argen
 */
@ExtendWith(MockitoExtension.class)
public class DuelBattleProviderTest {

    private DuelBattleProvider provider;

    @BeforeEach
    void setUp() {
        provider = new DuelBattleProvider();
    }

    @Test
    void testSetUpBattle() {
        Fighter fighter1 = Fighter.builder().name("Fighter 1").build();
        Fighter fighter2 = Fighter.builder().name("Fighter 2").build();

        Battle battle = provider.setUpBattle(fighter1, fighter2, new NoopBattleLogger());
        assertTrue(battle instanceof DuelBattle);
    }
}
