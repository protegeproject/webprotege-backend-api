package edu.stanford.protege.webprotege.change;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.diff.DiffElement;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27/02/15
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectChange_TestCase {


    private ProjectChange projectChange;

    private ProjectChange otherProjectChange;

    @Mock
    private RevisionNumber revisionNumber;

    private UserId userId = new UserId("UserA");

    private final int changeCount = 3;

    private final long timestamp = 100;

    private final String summary = "The Summary";

    @Mock
    private Page<DiffElement<String, String>> diff;

    @Mock
    private ImmutableSet<OWLEntityData> subjects;

    @Before
    public void setUp() throws Exception {
        projectChange = ProjectChange.get(revisionNumber, userId, timestamp, summary, changeCount, diff);
        otherProjectChange = ProjectChange.get(revisionNumber, userId, timestamp, summary, changeCount, diff);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_RevisionNumber_IsNull() {
        ProjectChange.get(null, userId, timestamp, summary, changeCount, diff);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_UserId_IsNull() {
        ProjectChange.get(revisionNumber, null, timestamp, summary, changeCount, diff);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_Summary_IsNull() {
        ProjectChange.get(revisionNumber, userId, timestamp, null, changeCount, diff);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_Diff_IsNull() {
        ProjectChange.get(revisionNumber, userId, timestamp, summary, changeCount, null);
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