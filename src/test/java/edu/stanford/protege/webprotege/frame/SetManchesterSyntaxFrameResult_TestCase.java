package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;
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
 * 17/01/15
 */
@RunWith(MockitoJUnitRunner.class)
public class SetManchesterSyntaxFrameResult_TestCase {


    private SetManchesterSyntaxFrameResult setManchesterSyntaxFrameResult;

    private SetManchesterSyntaxFrameResult otherSetManchesterSyntaxFrameResult;

    @Mock
    private EventList<ProjectEvent> eventList;

    private String frameText;

    @Before
    public void setUp() throws Exception {
        frameText = "FRAME TEXT";
        setManchesterSyntaxFrameResult = new SetManchesterSyntaxFrameResult(frameText);
        otherSetManchesterSyntaxFrameResult = new SetManchesterSyntaxFrameResult(frameText);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_EventList_IsNull() {
        new SetManchesterSyntaxFrameResult(frameText);
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_FrameText_IsNull() {
        new SetManchesterSyntaxFrameResult(null);
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(setManchesterSyntaxFrameResult, is(equalTo(setManchesterSyntaxFrameResult)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(setManchesterSyntaxFrameResult, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(setManchesterSyntaxFrameResult, is(equalTo(otherSetManchesterSyntaxFrameResult)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(setManchesterSyntaxFrameResult.hashCode(), is(otherSetManchesterSyntaxFrameResult.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(setManchesterSyntaxFrameResult.toString(), startsWith("SetManchesterSyntaxFrameResult"));
    }

    @Test
    public void shouldReturnSuppliedFrameText() {
        assertThat(setManchesterSyntaxFrameResult.frameText(), is(frameText));
    }
}