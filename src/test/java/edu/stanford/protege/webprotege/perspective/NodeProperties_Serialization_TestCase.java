package edu.stanford.protege.webprotege.perspective;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-30
 */
public class NodeProperties_Serialization_TestCase {

    private NodeProperties nodeProperties;

    @BeforeEach
    public void setUp() throws Exception {
        nodeProperties = NodeProperties.builder()
                .setValue("a", "b")
                .build();
    }

    @Test
    public void shouldSerializeNodeProperties() throws IOException {

    }
}
