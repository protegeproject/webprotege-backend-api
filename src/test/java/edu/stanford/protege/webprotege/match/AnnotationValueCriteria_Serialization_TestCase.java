package edu.stanford.protege.webprotege.match;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.criteria.*;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Jun 2018
 */
public class AnnotationValueCriteria_Serialization_TestCase {

    private static <V extends AnnotationValueCriteria> void testSerialization(V value) throws IOException {

    }

    @Test
    public void shouldSerialize_LiteralLexicalValueNotInDatatypeLexicalSpaceCriteria() throws IOException {
        testSerialization(
                LiteralLexicalValueNotInDatatypeLexicalSpaceCriteria.get()
        );
    }

    @Test
    public void shouldSerialize_IriEqualsCriteria() throws IOException {
        testSerialization(
                IriEqualsCriteria.get(IRI.create("http://stuff.com/A"))
        );
    }

    @Test
    public void shouldSerialize_IriHasAnnotationsCriteria() throws IOException {
        testSerialization(
                IriHasAnnotationCriteria.get(
                        AnnotationComponentsCriteria.get(
                                AnyAnnotationPropertyCriteria.get(),
                                AnyAnnotationValueCriteria.get()
                        )
                )
        );
    }

    @Test
    public void shouldSerialize_CompositeAnnotationValueCriteria() throws IOException {
        testSerialization(
                CompositeAnnotationValueCriteria.get(
                        ImmutableList.of(
                                AnyAnnotationValueCriteria.get(),
                                StringContainsCriteria.get("A", true)
                        )
                        , MultiMatchType.ALL)
        );
    }
}
