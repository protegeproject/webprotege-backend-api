package edu.stanford.protege.webprotege.viz;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-06
 */
public class AnySubClassOfEdgeCriteria_SerializationTestCase {

    private static <V extends EdgeCriteria> void testSerialization(V value) throws IOException {

    }

    @Test
    public void shouldSerialize_AnySubClassOfOfEdgeCriteria() throws IOException {
        testSerialization(AnySubClassOfEdgeCriteria.get());
    }
}
