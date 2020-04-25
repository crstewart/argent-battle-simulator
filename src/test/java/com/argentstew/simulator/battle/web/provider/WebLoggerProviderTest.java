package com.argentstew.simulator.battle.web.provider;

import com.argentstew.simulator.battle.web.log.WebLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Writer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * com.argentstew.simulator.battle.web.provider
 * 4/24/2020
 *
 * @author argen
 */
public class WebLoggerProviderTest {

    private WebLoggerProvider provider;

    @BeforeEach
    void setUp() {
        provider = new WebLoggerProvider();
    }

    @Test
    void testGetLogger() throws Exception {
        Writer writer = mock(Writer.class);

        WebLogger webLogger = provider.getLogger(writer);
        assertNotNull(webLogger);
        assertNotNull(webLogger.getUuid());
    }
}
