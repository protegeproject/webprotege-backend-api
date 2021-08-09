
package edu.stanford.protege.webprotege.ontology;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLOntologyID;

@RunWith(MockitoJUnitRunner.class)
public class OntologyIdData_TestCase {

    private OntologyIdData ontologyIdData;

    private final OWLOntologyID ontologyID = new OWLOntologyID();

    private final String browserText = "The browserText";

    @Before
    public void setUp()
        throws Exception
    {
        ontologyIdData = OntologyIdData.get(ontologyID, browserText);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_ontologyID_IsNull() {
        OntologyIdData.get(null, browserText);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_browserText_IsNull() {
        OntologyIdData.get(ontologyID, null);
    }

    @Test
    public void shouldReturnSupplied_browserText() {
        MatcherAssert.assertThat(ontologyIdData.getBrowserText(), Matchers.is(this.browserText));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(ontologyIdData, Matchers.is(ontologyIdData));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(ontologyIdData.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(ontologyIdData, Matchers.is(OntologyIdData.get(ontologyID, browserText)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_ontologyID() {
        MatcherAssert.assertThat(ontologyIdData, Matchers.is(Matchers.not(OntologyIdData.get(new OWLOntologyID(), browserText))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_browserText() {
        MatcherAssert.assertThat(ontologyIdData, Matchers.is(Matchers.not(OntologyIdData.get(ontologyID, "String-113be408-6933-4a00-833b-5df2376852f2"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(ontologyIdData.hashCode(), Matchers.is(OntologyIdData.get(ontologyID, browserText).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(ontologyIdData.toString(), Matchers.startsWith("OntologyIdData"));
    }

    @Test
    public void should_getUnquotedBrowserText() {
        MatcherAssert.assertThat(ontologyIdData.getUnquotedBrowserText(), Matchers.is(browserText));
    }

}
