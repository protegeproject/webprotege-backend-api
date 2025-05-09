package edu.stanford.protege.webprotege.viz;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.criteria.MultiMatchType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-07
 */
public class CompositeEdgeCriteria_SerializationTestCase {

    private static <V extends EdgeCriteria> void testSerialization(V value) throws IOException {

    }

    @Test
    public void shouldSerialize_AnyEdgeCriteria() throws IOException {
        testSerialization(CompositeEdgeCriteria.get(
                ImmutableList.of(
                        AnySubClassOfEdgeCriteria.get(),
                        AnyInstanceOfEdgeCriteria.get()
                ),
                MultiMatchType.ANY
        ));
    }

}
