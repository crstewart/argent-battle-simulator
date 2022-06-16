package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.Battle;
import com.argentstew.simulator.battle.factory.FighterFactory;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.web.file.FileAccessor;
import com.argentstew.simulator.battle.web.file.FileStore;
import com.argentstew.simulator.battle.web.log.WebLogger;
import com.argentstew.simulator.battle.web.model.SimulationResult;
import com.argentstew.simulator.battle.web.provider.BattleProvider;
import com.argentstew.simulator.battle.web.provider.LoggerProvider;
import com.argentstew.simulator.battle.web.repository.FighterRepository;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * com.argentstew.simulator.battle.web.service
 * 4/23/2020
 *
 * @author argen
 */
@ExtendWith(MockitoExtension.class)
public class DuelSimulatorServiceTest {

    @InjectMocks
    private DuelSimulatorService service;

    @Mock
    private FighterFactory fighterFactory;

    @Mock
    private FighterRepository fighterRepository;

    @Mock
    private BattleProvider battleProvider;

    @Mock
    private LoggerProvider<WebLogger> loggerProvider;

    @Mock
    private FileAccessor fileAccessor;

    @Mock
    private FileStore fileStore;

    @Mock
    private WebLogger logger;

    @Mock
    private Battle battle;

    @Test
    void testRun_Success() throws Exception {
        String testOwner = "Test Co.";

        when(fighterFactory.getFighter(anyString())).thenReturn(Fighter.builder().build());
        when(fighterRepository.findByName(anyString()))
                .thenReturn(Optional.of(
                        com.argentstew.simulator.battle.web.persistence.Fighter.builder().copyrightOwner(testOwner).build()
                ));
        when(battleProvider.setUpBattle(any(Fighter.class), any(Fighter.class), any(BattleLogger.class)))
                .thenReturn(battle);
        when(loggerProvider.getLogger(any(Writer.class))).thenReturn(logger);
        when(logger.getUuid()).thenReturn("abc");

        SimulationResult result = service.run("fighter1", "fighter2");
        assertEquals(testOwner, result.getFighter1().getCopyrightOwner());
        assertEquals(testOwner, result.getFighter2().getCopyrightOwner());
        assertEquals("Draw", result.getWinner());
        assertEquals("abc", result.getId());
        assertTrue(StringUtils.isBlank(result.getMessage()));

        verify(fileStore).saveFile(anyString(), anyString(), any(InputStream.class));
    }

    @Test
    void testRun_InvalidFighter() {
        when(fighterFactory.getFighter(anyString())).thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class, () -> service.run("1", "2"));
    }

    @Test
    void testFetchSimulation_Success() {
        when(fileAccessor.getLogFile(anyString(), anyString())).thenReturn("Hello, simulator!");

        assertEquals("Hello, simulator!", service.fetchSimulation("abc"));
    }
}
