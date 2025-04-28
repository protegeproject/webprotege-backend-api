package edu.stanford.protege.webprotege;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.semanticweb.owlapi.model.OWLLiteral;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 19/04/2014
 */
public class OWLLiteralWithLexicalValueMatcher extends TypeSafeMatcher<OWLLiteral> {

    private final String expected;

    public OWLLiteralWithLexicalValueMatcher(String expectedLexicalValue) {
        this.expected = expectedLexicalValue;
    }

    public static OWLLiteralWithLexicalValueMatcher literalWithLexicalValue(String lexicalValue) {
        return new OWLLiteralWithLexicalValueMatcher(lexicalValue);
    }

    @Override
    protected boolean matchesSafely(OWLLiteral literal) {
        return expected.equals(literal.getLiteral());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("does not have lexical value");
    }
}
