package edu.stanford.protege.webprotege;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLLiteral;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 19/04/2014
 */
public class RdfsLabelWithLexicalValueAndLang extends TypeSafeMatcher<OWLAnnotationAssertionAxiom> {

    private final String expectedValue;

    private final String lang;

    public RdfsLabelWithLexicalValueAndLang(String expectedValue, String lang) {
        this.expectedValue = expectedValue;
        this.lang = lang;
    }

    public static RdfsLabelWithLexicalValueAndLang rdfsLabelWithLexicalValueAndLang(String lexicalValue, String lang) {
        return new RdfsLabelWithLexicalValueAndLang(lexicalValue, lang);
    }

    @Override
    protected boolean matchesSafely(OWLAnnotationAssertionAxiom item) {
        if (!item.getProperty().isLabel()) {
            return false;
        }
        OWLAnnotationValue value = item.getValue();
        return value instanceof OWLLiteral && ((OWLLiteral) value).getLiteral().equals(expectedValue)
                && lang.equals(((OWLLiteral) value).getLang());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("rdfs:Label annotation assertion with \"" + expectedValue + "\" value");
    }
}
