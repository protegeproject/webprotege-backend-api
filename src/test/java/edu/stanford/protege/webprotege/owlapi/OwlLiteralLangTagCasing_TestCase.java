package edu.stanford.protege.webprotege.owlapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-08-31
 * <p>
 * Test to check that OWL API lower cases lang tags when creating literals
 */
public class OwlLiteralLangTagCasing_TestCase {

    private OWLDataFactoryImpl dataFactory;

    @BeforeEach
    public void setUp() {
        dataFactory = new OWLDataFactoryImpl();
    }

    @Test
    public void shouldLowerCaseLangTag() {
        var literal = dataFactory.getOWLLiteral("lexicalvalue", "EN");
        assertThat(literal.getLang(), is("en"));
    }
}
