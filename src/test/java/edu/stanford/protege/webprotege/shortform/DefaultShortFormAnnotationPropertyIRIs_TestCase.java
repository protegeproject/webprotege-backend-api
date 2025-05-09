package edu.stanford.protege.webprotege.shortform;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.DefaultShortFormAnnotationPropertyIRIs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.semanticweb.owlapi.vocab.SKOSVocabulary;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 30/01/15
 */
public class DefaultShortFormAnnotationPropertyIRIs_TestCase {

    private ImmutableList<IRI> defaultLabellingIRIs;

    @BeforeEach
    public void setUp() throws Exception {
        defaultLabellingIRIs = DefaultShortFormAnnotationPropertyIRIs.asImmutableList();
    }

    @Test
    public void shouldContainRDFSLabel() {
        assertThat(defaultLabellingIRIs, hasItem(OWLRDFVocabulary.RDFS_LABEL.getIRI()));
    }

    @Test
    public void shouldContainSKOSPrefLabel() {
        assertThat(defaultLabellingIRIs, hasItem(SKOSVocabulary.PREFLABEL.getIRI()));
    }


}
