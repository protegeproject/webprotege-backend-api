package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.LangTag;
import edu.stanford.protege.webprotege.common.LangTagFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-26
 */
@JsonTest
public class LangTagFilter_TestCase {

    @Mock
    private LangTag langTag, otherLangTag;

    @SuppressWarnings("ConstantConditions")
    @Test
    public void shouldThrowNpeForNullSet() {
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    LangTagFilter.get(null);
                });
    }

    @Test
    public void shouldIncludeAnyLangTagForEmptySet() {
        LangTagFilter langTagFilter = LangTagFilter.get(ImmutableSet.of());
        assertThat(langTagFilter.isIncluded(langTag), is(true));
    }

    @Test
    public void shouldIncludeAnyExplicitLangTag() {
        LangTagFilter langTagFilter = LangTagFilter.get(ImmutableSet.of(langTag));
        assertThat(langTagFilter.isIncluded(langTag), is(true));
    }


    @Test
    public void shouldNotIncludeAnyNonExplicityLangTagInNonEmptySet() {
        LangTagFilter langTagFilter = LangTagFilter.get(ImmutableSet.of(langTag));
        assertThat(langTagFilter.isIncluded(otherLangTag), is(false));
    }
}
