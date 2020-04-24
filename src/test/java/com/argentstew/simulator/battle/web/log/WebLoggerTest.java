package com.argentstew.simulator.battle.web.log;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.StringWriter;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;

/**
 * com.argentstew.simulator.battle.web.log
 * 4/23/2020
 *
 * @author argen
 */
@ExtendWith(MockitoExtension.class)
public class WebLoggerTest {

    private static final String HELLO_SIMULATOR = "Hello, simulator!";

    private WebLogger logger;

    @Mock
    private StringWriter stringWriter;

    private String message;

    @BeforeEach
    void setUp() throws Exception {
        logger = new WebLogger(stringWriter);
    }

    @Test
    void testGetUuid() {
        String id = logger.getUuid();
        UUID uuid = UUID.fromString(id);
        assertEquals(id, uuid.toString());
    }

    @Test
    void testLog() throws Exception {
        doAnswer(o -> message = o.getArgument(0, String.class)).when(stringWriter).write(anyString());
        logger.open();
        logger.log(HELLO_SIMULATOR);
        logger.close();
        logger.cleanup();

        assertEquals(HELLO_SIMULATOR + "\n", message);
    }
}
