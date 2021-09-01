package edu.stanford.protege.webprotege.crud;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.criteria.HierarchyFilterType;
import edu.stanford.protege.webprotege.criteria.SubClassOfCriteria;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationDescriptor;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
import edu.stanford.protege.webprotege.crud.gen.IncrementingPatternDescriptor;
import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixSettings;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-07
 */
public class EntityCrudKitSettings_SerializationTestCase {

    private EntityCrudKitSettings<UuidSuffixSettings> settings;

    @Before
    public void setUp() {
     }

    @Test
    public void shouldRoundTrip() throws IOException {
    }
}
