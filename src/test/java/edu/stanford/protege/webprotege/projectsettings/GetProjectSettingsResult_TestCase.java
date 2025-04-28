package edu.stanford.protege.webprotege.projectsettings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetProjectSettingsResult_TestCase {

    @Mock
    private ProjectSettings settings;

    private GetProjectSettingsResult result;

    @BeforeEach
    public void setUp() throws Exception {
        result = new GetProjectSettingsResult(settings);
    }


    public void shouldThrowNullPointerExceptionIf_ProjectSettings_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetProjectSettingsResult(null);
        });
    }

    @Test
    public void shouldReturnSupplied_ProjectSettings() {
        assertThat(result.settings(), is(settings));
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
        GetProjectSettingsResult other = new GetProjectSettingsResult(settings);
        assertThat(result, is(equalTo(other)));
    }

    @Test
    public void shouldHaveSameHashCode() {
        GetProjectSettingsResult other = new GetProjectSettingsResult(settings);
        assertThat(result.hashCode(), is(other.hashCode()));
    }
}
