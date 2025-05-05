package edu.stanford.protege.webprotege.viz;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.criteria.EntityTypeIsOneOfCriteria;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.EntityType;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-06
 */
public class HeadNodeMatchesCriteria_SerializationTestCase {

    private static <V extends EdgeCriteria> void testSerialization(V value) throws IOException {

    }

    @Test
    public void shouldSerialize_HeadNodeMatchesCriteria() throws IOException {
        testSerialization(HeadNodeMatchesCriteria.get(EntityTypeIsOneOfCriteria.get(ImmutableSet.of(EntityType.CLASS))));
    }
}
