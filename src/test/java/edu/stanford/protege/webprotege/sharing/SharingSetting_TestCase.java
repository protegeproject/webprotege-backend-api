package edu.stanford.protege.webprotege.sharing;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SharingSetting_TestCase {

    private final SharingPermission sharingPermission = SharingPermission.EDIT;

    private SharingSetting sharingSetting;

    @Mock
    private PersonId personId;

    @BeforeEach
    public void setUp()
            throws Exception {
        sharingSetting = new SharingSetting(personId, sharingPermission);
    }

    public void shouldThrowNullPointerExceptionIf_personId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SharingSetting(null, sharingPermission);
        });
    }

    @Test
    public void shouldReturnSupplied_personId() {
        MatcherAssert.assertThat(sharingSetting.getPersonId(), Matchers.is(this.personId));
    }

    public void shouldThrowNullPointerExceptionIf_sharingSetting_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new SharingSetting(personId, null);
        });
    }

    @Test
    public void shouldReturnSupplied_sharingSetting() {
        MatcherAssert.assertThat(sharingSetting.getSharingPermission(), Matchers.is(this.sharingPermission));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(sharingSetting, Matchers.is(sharingSetting));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(sharingSetting.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(sharingSetting, Matchers.is(new SharingSetting(personId, sharingPermission)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_personId() {
        MatcherAssert.assertThat(sharingSetting, Matchers.is(Matchers.not(new SharingSetting(Mockito.mock(PersonId.class), sharingPermission))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_sharingSetting() {
        MatcherAssert.assertThat(sharingSetting, Matchers.is(Matchers.not(new SharingSetting(personId, SharingPermission.COMMENT))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(sharingSetting.hashCode(), Matchers.is(new SharingSetting(personId, sharingPermission).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(sharingSetting.toString(), Matchers.startsWith("UserSharingSetting"));
    }
}
