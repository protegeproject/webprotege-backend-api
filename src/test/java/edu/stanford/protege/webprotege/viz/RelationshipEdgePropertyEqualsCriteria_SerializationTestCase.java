package edu.stanford.protege.webprotege.viz;

import edu.stanford.protege.webprotege.MockingUtils;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.OWLProperty;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-06
 */
public class RelationshipEdgePropertyEqualsCriteria_SerializationTestCase {

    private final OWLProperty property = MockingUtils.mockOWLObjectProperty();

    private static <V extends EdgeCriteria> void testSerialization(V value) throws IOException {

    }

    @Test
    public void shouldSerialize_RelationshipEdgePropertyEqualsCriteria() throws IOException {
        testSerialization(RelationshipEdgePropertyEqualsCriteria.get(property));
    }
}
