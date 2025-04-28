package edu.stanford.protege.webprotege.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@ExtendWith(MockitoExtension.class)
public class MergeEntitiesResult_TestCase {

    private MergeEntitiesResult mergeEntitiesResult;

    @BeforeEach
    public void setUp() {
        mergeEntitiesResult = new MergeEntitiesResult();
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(mergeEntitiesResult, is(mergeEntitiesResult));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(mergeEntitiesResult.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(mergeEntitiesResult, is(new MergeEntitiesResult()));
    }


    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(mergeEntitiesResult.hashCode(), is(new MergeEntitiesResult().hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(mergeEntitiesResult.toString(), startsWith("MergeEntitiesResult"));
    }

}
