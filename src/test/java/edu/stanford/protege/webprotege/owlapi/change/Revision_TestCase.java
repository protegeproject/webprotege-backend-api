package edu.stanford.protege.webprotege.owlapi.change;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.change.OntologyChange;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.revision.Revision;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Revision_TestCase {

    private final long timestamp = 1L;

    private final String highLevelDescription = "The highLevelDescription";

    private final UserId userId = new UserId("UserA");

    private Revision revision;

    @Mock
    private RevisionNumber revisionNumber;

    @Mock
    private ImmutableList<OntologyChange> changes;

    @BeforeEach
    public void setUp() throws Exception {
        revision = new Revision(userId, revisionNumber, changes, timestamp, highLevelDescription);
    }

    public void shouldThrowNullPointerExceptionIf_userId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Revision(null, revisionNumber, changes, timestamp, highLevelDescription);
        });
    }

    @Test
    public void shouldReturnSupplied_userId() {
        MatcherAssert.assertThat(revision.getUserId(), Matchers.is(this.userId));
    }

    public void shouldThrowNullPointerExceptionIf_revisionNumber_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Revision(userId, null, changes, timestamp, highLevelDescription);
        });
    }

    @Test
    public void shouldReturnSupplied_revisionNumber() {
        MatcherAssert.assertThat(revision.getRevisionNumber(), Matchers.is(this.revisionNumber));
    }

    public void shouldThrowNullPointerExceptionIf_changes_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Revision(userId, revisionNumber, null, timestamp, highLevelDescription);
        });
    }

    @Test
    public void shouldReturnSupplied_timestamp() {
        MatcherAssert.assertThat(revision.getTimestamp(), Matchers.is(this.timestamp));
    }

    public void shouldThrowNullPointerExceptionIf_highLevelDescription_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new Revision(userId, revisionNumber, changes, timestamp, null);
        });
    }

    @Test
    public void shouldReturnSupplied_highLevelDescription() {
        MatcherAssert.assertThat(revision.getHighLevelDescription(), Matchers.is(this.highLevelDescription));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(revision, Matchers.is(revision));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(revision.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(revision, Matchers.is(new Revision(userId, revisionNumber, changes, timestamp, highLevelDescription)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_userId() {
        MatcherAssert.assertThat(revision, Matchers.is(Matchers.not(new Revision(new UserId("OtherUser"), revisionNumber, changes, timestamp, highLevelDescription))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_revisionNumber() {
        MatcherAssert.assertThat(revision, Matchers.is(Matchers.not(new Revision(userId, mock(RevisionNumber.class), changes, timestamp, highLevelDescription))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_changes() {
        MatcherAssert.assertThat(revision, Matchers.is(Matchers.not(new Revision(userId, revisionNumber, mock(ImmutableList.class), timestamp, highLevelDescription))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_timestamp() {
        MatcherAssert.assertThat(revision, Matchers.is(Matchers.not(new Revision(userId, revisionNumber, changes, 2L, highLevelDescription))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_highLevelDescription() {
        MatcherAssert.assertThat(revision, Matchers.is(Matchers.not(new Revision(userId, revisionNumber, changes, timestamp, "String-da7e91b0-376b-4bdf-903a-61d17ea23378"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(revision.hashCode(), Matchers.is(new Revision(userId, revisionNumber, changes, timestamp, highLevelDescription).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(revision.toString(), Matchers.startsWith("Revision"));
    }

    @Test
    public void should_getSize() {
        when(changes.size()).thenReturn(3);
        MatcherAssert.assertThat(revision.getSize(), Matchers.is(3));
    }

}
