package edu.stanford.protege.webprotege.sharing;

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
public class GetProjectSharingSettingsResult_TestCase {


    private GetProjectSharingSettingsResult result;

    private GetProjectSharingSettingsResult otherResult;

    @Mock
    private ProjectSharingSettings projectSharingSettings;

    @BeforeEach
    public void setUp() throws Exception {
        result = new GetProjectSharingSettingsResult(projectSharingSettings);
        otherResult = new GetProjectSharingSettingsResult(projectSharingSettings);
    }

    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectSharingSettingsResult(null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(result, is(equalTo(result)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(result, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(result, is(equalTo(otherResult)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(result.hashCode(), is(otherResult.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(result.toString(), startsWith("GetProjectSharingSettingsResult"));
    }

    @Test
    public void shouldReturnSuppliedSharingSettings() {
        assertThat(result.settings(), is(projectSharingSettings));
    }
}