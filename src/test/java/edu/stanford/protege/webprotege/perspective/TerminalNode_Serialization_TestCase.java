package edu.stanford.protege.webprotege.perspective;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-30
 */
public class TerminalNode_Serialization_TestCase {

    private TerminalNode terminalNode;

    @BeforeEach
    public void setUp() throws Exception {
        terminalNode = new TerminalNode(TerminalNodeId.get());
    }

    @Test
    public void shouldSerializeTerminalNode() throws IOException {

    }
}
