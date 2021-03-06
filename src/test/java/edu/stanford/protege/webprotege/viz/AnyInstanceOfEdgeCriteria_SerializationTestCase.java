package edu.stanford.protege.webprotege.viz;


import org.junit.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-06
 */
public class AnyInstanceOfEdgeCriteria_SerializationTestCase {

    @Test
    public void shouldSerialize_AnyInstanceOfEdgeCriteria() throws IOException {
        testSerialization(AnyInstanceOfEdgeCriteria.get());
    }

    private static <V extends EdgeCriteria> void testSerialization(V value) throws IOException {
        
    }
}
