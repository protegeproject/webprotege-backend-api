package edu.stanford.protege.webprotege.sharing;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PersonId_TestCase {

    private final String id = "The id";

    private PersonId personId;

    @BeforeEach
    public void setUp()
            throws Exception {
        personId = PersonId.get(id);
    }

    public void shouldThrowNullPointerExceptionIf_id_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            PersonId.get(null);
        });
    }

    @Test
    public void shouldReturnSupplied_id() {
        MatcherAssert.assertThat(personId.getId(), Matchers.is(this.id));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(personId, Matchers.is(personId));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(personId.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(personId, Matchers.is(PersonId.get(id)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_id() {
        MatcherAssert.assertThat(personId, Matchers.is(Matchers.not(PersonId.get("String-42926bfe-4f72-4c74-99aa-aef99f86dabe"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(personId.hashCode(), Matchers.is(PersonId.get(id).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(personId.toString(), Matchers.startsWith("PersonId"));
    }

}
