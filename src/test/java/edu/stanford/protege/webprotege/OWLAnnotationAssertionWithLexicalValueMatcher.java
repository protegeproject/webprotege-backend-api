package edu.stanford.protege.webprotege;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLLiteral;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 19/04/2014
 */
public class OWLAnnotationAssertionWithLexicalValueMatcher extends TypeSafeMatcher<OWLAnnotationAssertionAxiom> {

    private final String expectedValue;

    public OWLAnnotationAssertionWithLexicalValueMatcher(String expectedValue) {
        this.expectedValue = checkNotNull(expectedValue);
    }

    public static OWLAnnotationAssertionWithLexicalValueMatcher annotationAssertionWithLexicalValue(String lexicalValue) {
        return new OWLAnnotationAssertionWithLexicalValueMatcher(lexicalValue);
    }

    @Override
    protected boolean matchesSafely(OWLAnnotationAssertionAxiom item) {
        OWLAnnotationValue value = item.getValue();
        return value instanceof OWLLiteral && ((OWLLiteral) value).getLiteral().equals(expectedValue);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("annotation assertion with lexical value");
    }
}
