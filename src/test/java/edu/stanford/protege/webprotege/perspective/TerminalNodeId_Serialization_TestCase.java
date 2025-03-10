package edu.stanford.protege.webprotege.perspective;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-30
 */
public class TerminalNodeId_Serialization_TestCase {

    private TerminalNodeId nodeId;

    @BeforeEach
    public void setUp() throws Exception {
        nodeId = TerminalNodeId.get();
    }

    @Test
    public void shouldSerializeTerminalNodeId() throws IOException {

    }
}
