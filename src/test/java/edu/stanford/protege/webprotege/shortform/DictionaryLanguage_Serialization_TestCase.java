package edu.stanford.protege.webprotege.shortform;

import edu.stanford.protege.webprotege.common.AnnotationAssertionDictionaryLanguage;
import edu.stanford.protege.webprotege.common.DictionaryLanguage;
import edu.stanford.protege.webprotege.common.LocalNameDictionaryLanguage;
import edu.stanford.protege.webprotege.common.OboIdDictionaryLanguage;

import org.junit.Test;

import java.io.IOException;

public class DictionaryLanguage_Serialization_TestCase {

    @Test
    public void shouldSerializeLocalNameDictionaryLanguage() throws IOException {
        var dictionaryLanguage = LocalNameDictionaryLanguage.get();

    }

    @Test
    public void shouldSerializeOboIdDictionaryLanguage() throws IOException {
        var dictionaryLanguage = OboIdDictionaryLanguage.get();

    }

    @Test
    public void shouldSerializeAnnotationBasedDictionaryLanguage() throws IOException {
        var dictionaryLanguage = AnnotationAssertionDictionaryLanguage.rdfsLabel("en");

    }

    @Test
    public void shouldDeserializeLocalNameLegacySerialization() throws IOException {
        var localName = LocalNameDictionaryLanguage.get();

    }

    @Test
    public void shouldDeserializeAnnotationAssertionWithEmptyLanguageTagLegacySerialization() throws IOException {
        var iriString = "http://example.org/prop";
        var dictionaryLanguage = AnnotationAssertionDictionaryLanguage.get(iriString, "");
        var serialization = String.format("{\"propertyIri\":\"%s\"}", iriString);

    }

    @Test
    public void shouldDeserializeAnnotationAssertionWithNonEmptyLanguageTagLegacySerialization() throws IOException {
        var iriString = "http://example.org/prop";
        var dictionaryLanguage = AnnotationAssertionDictionaryLanguage.get(iriString, "en");
        var serialization = String.format("{\"propertyIri\":\"%s\", \"lang\":\"en\"}", iriString);

    }
}
