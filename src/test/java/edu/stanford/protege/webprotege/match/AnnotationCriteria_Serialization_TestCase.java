package edu.stanford.protege.webprotege.match;

import edu.stanford.protege.webprotege.criteria.*;
import org.junit.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Jun 2018
 */
public class AnnotationCriteria_Serialization_TestCase {

    @Test
    public void shouldSerialize_AnnotationComponentCriteria() throws IOException {
        testSerialization(
                AnnotationComponentsCriteria.get(
                        AnyAnnotationPropertyCriteria.get(),
                        AnyAnnotationValueCriteria.get(),
                        AnyAnnotationSetCriteria.get()
                )
        );
    }

    private static <V extends AnnotationCriteria> void testSerialization(V value) throws IOException {
        
    }
}
