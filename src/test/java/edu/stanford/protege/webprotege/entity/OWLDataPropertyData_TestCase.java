
package edu.stanford.protege.webprotege.entity;

import com.google.common.collect.ImmutableMap;
import edu.stanford.protege.webprotege.shortform.DictionaryLanguage;
import edu.stanford.protege.webprotege.shortform.LocalNameDictionaryLanguage;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;

import static edu.stanford.protege.webprotege.PrimitiveType.DATA_PROPERTY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OWLDataPropertyData_TestCase {

    private OWLDataPropertyData oWLDataPropertyData;

    @Mock
    private OWLDataProperty entity;

    private final String browserText = "The browserText";

    private ImmutableMap<DictionaryLanguage, String> shortForms;

    @Before
    public void setUp() {
        shortForms = ImmutableMap.of(LocalNameDictionaryLanguage.get(), browserText);
        when(entity.getIRI()).thenReturn(IRI.create("http://example.org/x"));
        oWLDataPropertyData = OWLDataPropertyData.get(entity, shortForms);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_entity_IsNull() {
        OWLDataPropertyData.get(null, shortForms);
    }

    @Test
    public void shouldReturnSupplied_entity() {
        assertThat(oWLDataPropertyData.getEntity(), is(this.entity));
    }

    @Test
    public void shouldReturnSupplied_browserText() {
        assertThat(oWLDataPropertyData.getBrowserText(), is(this.browserText));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(oWLDataPropertyData, is(oWLDataPropertyData));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(oWLDataPropertyData.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(oWLDataPropertyData, is(OWLDataPropertyData.get(entity, shortForms)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_entity() {
        assertThat(oWLDataPropertyData, is(not(OWLDataPropertyData.get(Mockito.mock(OWLDataProperty.class), shortForms))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(oWLDataPropertyData.hashCode(), is(OWLDataPropertyData.get(entity, shortForms).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(oWLDataPropertyData.toString(), Matchers.startsWith("OWLDataPropertyData"));
    }

    @Test
    public void should_getType() {
        assertThat(oWLDataPropertyData.getType(), is(DATA_PROPERTY));
    }

    @Test
    public void shouldReturn_false_For_isOWLAnnotationProperty() {
        assertThat(oWLDataPropertyData.isOWLAnnotationProperty(), is(false));
    }
}
