package edu.stanford.protege.webprotege.shortform;

import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.ShortForm;

import org.junit.Test;

import java.io.IOException;

public class ShortForm_Serialization_TestCase {

    @Test
    public void shouldSerializeLocalNameShortForm() throws IOException {
        var shortForm = ShortForm.get(
                DictionaryLanguage.localName(),
                "Hello"
        );
        
    }

    @Test
    public void shouldSerializeAnnotationBasedShortFormWithEmptyLangTag() throws IOException {
        var shortForm = ShortForm.get(
                DictionaryLanguage.rdfsLabel(""),
                "Hello"
        );
        
    }

    @Test
    public void shouldSerializeAnnotationBasedShortFormWithNonEmptyLangTag() throws IOException {
        var shortForm = ShortForm.get(
                DictionaryLanguage.rdfsLabel("en"),
                "Hello"
        );
        
    }
}
