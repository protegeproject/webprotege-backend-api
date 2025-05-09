package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.LanguageCode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LanguageCode_TestCase {

    private final String lang = "The lang";

    private final String name = "The name";

    private LanguageCode languageCode;

    @BeforeEach
    public void setUp() {
        languageCode = new LanguageCode(lang, name);
    }

    @Test
    public void shouldThrowNullPointerExceptionIf_lang_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new LanguageCode(null, name);
        });
    }

    @Test
    public void shouldReturnSupplied_lang() {
        assertThat(languageCode.getLang(), is(this.lang));
    }

    @Test
    public void shouldThrowNullPointerExceptionIf_name_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new LanguageCode(lang, null);
        });
    }

    @Test
    public void shouldReturnSupplied_name() {
        assertThat(languageCode.getName(), is(this.name));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(languageCode, is(languageCode));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(languageCode.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(languageCode, is(new LanguageCode(lang, name)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_lang() {
        assertThat(languageCode, is(not(new LanguageCode("String-59588e83-8ecb-409e-8fdd-12b14a3dbae7", name))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_name() {
        assertThat(languageCode, is(not(new LanguageCode(lang, "String-4ee0fde8-0c95-40c5-94ac-fc742e2b0e35"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(languageCode.hashCode(), is(new LanguageCode(lang, name).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(languageCode.toString(), Matchers.startsWith("LanguageCode"));
    }

    @Test
    public void should_compareTo() {
        assertThat(new LanguageCode("a0", "").compareTo(new LanguageCode("a1", "")), is(lessThan(0)));
    }

}
