package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.criteria.CompositeRootCriteria;
import edu.stanford.protege.webprotege.criteria.IsNotBuiltInEntityCriteria;
import edu.stanford.protege.webprotege.criteria.MultiMatchType;
import edu.stanford.protege.webprotege.projectsettings.EntityDeprecationSettings;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-10-23
 */
public class EntityDeprecationSettings_Serialization_TestCase {

    @Test
    public void shouldSerializeEmpty() throws IOException {
    }

    @Test
    public void shouldSerializeNonEmpty() throws IOException {
        var settings = EntityDeprecationSettings.get(IRI.create("http://example.org/seeAlso"),
                CompositeRootCriteria.get(
                        ImmutableList.of(IsNotBuiltInEntityCriteria.get()
                        ),
                        MultiMatchType.ALL
                ),
                MockingUtils.mockOWLClass(),
                MockingUtils.mockOWLObjectProperty(),
                MockingUtils.mockOWLDataProperty(),
                MockingUtils.mockOWLAnnotationProperty(),
                MockingUtils.mockOWLClass());

    }
}
