package edu.stanford.protege.webprotege.app;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ApplicationPreferences_TestCase {

    private final String applicationName = "The applicationName";

    private final String systemNotificationEmailAddress = "The SystemNotificationEmailAddress";

    private final long maxUploadSize = 1L;

    private ApplicationPreferences applicationPreferences;

    @Mock
    private ApplicationLocation applicationLocation;

    @BeforeEach
    public void setUp() {
        applicationPreferences = new ApplicationPreferences(applicationName, systemNotificationEmailAddress, applicationLocation, maxUploadSize);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_applicationName_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ApplicationPreferences(null, systemNotificationEmailAddress, applicationLocation, maxUploadSize);
        });
    }

    @Test
    public void shouldReturnSupplied_applicationName() {
        assertThat(applicationPreferences.getApplicationName(), is(this.applicationName));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_systemNotificationEmailAddress_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ApplicationPreferences(applicationName, null, applicationLocation, maxUploadSize);
        });
    }

    @Test
    public void shouldReturnSupplied_systemNotificationEmailAddress() {
        assertThat(applicationPreferences.getSystemNotificationEmailAddress(), is(this.systemNotificationEmailAddress));
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_applicationLocation_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ApplicationPreferences(applicationName, systemNotificationEmailAddress, null, maxUploadSize);
        });
    }

    @Test
    public void shouldReturnSupplied_applicationLocation() {
        assertThat(applicationPreferences.getApplicationLocation(), is(this.applicationLocation));
    }

    @Test
    public void shouldReturnSupplied_maxUploadSize() {
        assertThat(applicationPreferences.getMaxUploadSize(), is(this.maxUploadSize));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(applicationPreferences, is(applicationPreferences));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(applicationPreferences.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(applicationPreferences, is(new ApplicationPreferences(applicationName, systemNotificationEmailAddress, applicationLocation, maxUploadSize)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_applicationName() {
        assertThat(applicationPreferences, is(Matchers.not(new ApplicationPreferences("String-59344631-c3b4-4d9b-9091-e4cf31570afe", systemNotificationEmailAddress, applicationLocation, maxUploadSize))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_systemNotificationEmailAddress() {
        assertThat(applicationPreferences, is(Matchers.not(new ApplicationPreferences(applicationName, "String-05b955de-a3d7-4444-bef7-032fd22c0bb1", applicationLocation, maxUploadSize))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_applicationLocation() {
        assertThat(applicationPreferences, is(Matchers.not(new ApplicationPreferences(applicationName, systemNotificationEmailAddress, Mockito.mock(ApplicationLocation.class), maxUploadSize))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_maxUploadSize() {
        assertThat(applicationPreferences, is(Matchers.not(new ApplicationPreferences(applicationName, systemNotificationEmailAddress, applicationLocation, 2L))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(applicationPreferences.hashCode(), is(new ApplicationPreferences(applicationName, systemNotificationEmailAddress, applicationLocation, maxUploadSize).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(applicationPreferences.toString(), Matchers.startsWith("ApplicationPreferences"));
    }

}
