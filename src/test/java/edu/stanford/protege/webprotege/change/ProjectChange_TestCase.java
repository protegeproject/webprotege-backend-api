package edu.stanford.protege.webprotege.change;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.diff.DiffElement;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ProjectChange_TestCase {


    private final int changeCount = 3;

    private final long timestamp = 100;

    private final String summary = "The Summary";

    private final UserId userId = new UserId("UserA");

    private ProjectChange projectChange;

    private ProjectChange otherProjectChange;

    @Mock
    private RevisionNumber revisionNumber;

    @Mock
    private Page<DiffElement<String, String>> diff;

    @Mock
    private ImmutableSet<OWLEntityData> subjects;

    @BeforeEach
    public void setUp() throws Exception {
        projectChange = ProjectChange.get(revisionNumber, userId, timestamp, summary, changeCount, diff);
        otherProjectChange = ProjectChange.get(revisionNumber, userId, timestamp, summary, changeCount, diff);
    }

    public void shouldThrowNullPointerExceptionIf_RevisionNumber_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            ProjectChange.get(null, userId, timestamp, summary, changeCount, diff);
        });
    }

    public void shouldThrowNullPointerExceptionIf_UserId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            ProjectChange.get(revisionNumber, null, timestamp, summary, changeCount, diff);
        });
    }

    public void shouldThrowNullPointerExceptionIf_Summary_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            ProjectChange.get(revisionNumber, userId, timestamp, null, changeCount, diff);
        });
    }

    public void shouldThrowNullPointerExceptionIf_Diff_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            ProjectChange.get(revisionNumber, userId, timestamp, summary, changeCount, null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(projectChange, is(equalTo(projectChange)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(projectChange, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(projectChange, is(equalTo(otherProjectChange)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(projectChange.hashCode(), is(otherProjectChange.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(projectChange.toString(), startsWith("ProjectChange"));
    }

    @Test
    public void shouldReturnSupplied_RevisionNumber() {
        assertThat(projectChange.getRevisionNumber(), is(revisionNumber));
    }

    @Test
    public void shouldReturnSupplied_UserId() {
        assertThat(projectChange.getAuthor(), is(userId));
    }

    @Test
    public void shouldReturnSupplied_Timestamp() {
        assertThat(projectChange.getTimestamp(), is(timestamp));
    }

    @Test
    public void shouldReturnSupplied_Summary() {
        assertThat(projectChange.getSummary(), is(summary));
    }

    @Test
    public void shouldReturnSupplied_Diff() {
        assertThat(projectChange.getDiff(), is(diff));
    }
}