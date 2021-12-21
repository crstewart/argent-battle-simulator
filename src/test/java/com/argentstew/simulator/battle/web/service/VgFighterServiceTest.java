package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.factory.FighterFactory;
import com.argentstew.simulator.battle.web.model.FighterDTO;
import com.argentstew.simulator.battle.web.persistence.Fighter;
import com.argentstew.simulator.battle.web.repository.FighterRepository;
import com.argentstew.simulator.battle.web.test.TestFighter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * com.argentstew.simulator.battle.web.service
 * 4/24/2020
 *
 * @author argen
 */
@ExtendWith(MockitoExtension.class)
public class VgFighterServiceTest {

    @InjectMocks
    private VgFighterService service;

    @Mock
    private FighterFactory fighterFactory;

    @Mock
    private FighterRepository fighterRepository;

    @Test
    void testGetFighters() {
        List<String> fighters = Collections.singletonList("1");
        when(fighterFactory.getAllFighters()).thenReturn(fighters);

        assertEquals(fighters, service.getFighters());
    }

    @Test
    void testGetFighter_Success() {
        when(fighterFactory.getFighter(anyString())).thenReturn(TestFighter.get());
        when(fighterRepository.findByName(anyString())).thenReturn(Optional.of(new Fighter()));

        FighterDTO dto = service.getFighter("1");
        assertNotNull(dto);
        assertEquals("Test Fighter", dto.getName());
        assertEquals(5.0, dto.getStrength(), 0.01);
        assertEquals(150, dto.getHp());
    }

    @Test
    void testGetFighter_Error() {
        when(fighterFactory.getFighter(anyString())).thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class, () -> service.getFighter("1"));
    }
}
