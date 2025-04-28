package edu.stanford.protege.webprotege.perspective;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-30
 */
public class ParentNode_Serialization_TestCase {

    private ParentNode parentNode;

    @BeforeEach
    public void setUp() throws Exception {
        parentNode = new ParentNode(Direction.ROW);
    }

    @Test
    public void shouldSerializeParentNode() throws IOException {

    }
}
