package edu.stanford.protege.webprotege.user;

import edu.stanford.protege.webprotege.common.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserDetails_TestCase {


    private final String displayName = "Display name";

    private final Optional<String> emailAddress = Optional.of("Email Address");

    private final UserId userId = new UserId("UserA");

    private UserDetails userDetails;

    private UserDetails otherUserDetails;

    @BeforeEach
    public void setUp() throws Exception {
        userDetails = new UserDetails(userId, displayName, emailAddress);
        otherUserDetails = new UserDetails(userId, displayName, emailAddress);
    }

    public void shouldThrowNullPointerExceptionIf_UserId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new UserDetails(null, displayName, emailAddress);
        });
    }

    public void shouldThrowNullPointerExceptionIf_DisplayName_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new UserDetails(userId, null, emailAddress);
        });
    }

    public void shouldThrowNullPointerExceptionIf_EmailAddress_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new UserDetails(userId, displayName, null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(userDetails, is(equalTo(userDetails)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(userDetails, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(userDetails, is(equalTo(otherUserDetails)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(userDetails.hashCode(), is(otherUserDetails.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(userDetails.toString(), startsWith("UserDetails"));
    }

    @Test
    public void shouldReturnSuppliedUserId() {
        assertThat(userDetails.getUserId(), is(userId));
    }

    @Test
    public void shouldReturnSuppliedDisplayName() {
        assertThat(userDetails.getDisplayName(), is(displayName));
    }

    @Test
    public void shouldReturnSuppliedEmailAddress() {
        assertThat(userDetails.getEmailAddress(), is(emailAddress));
    }

    @Test
    public void shouldReturnGuestDetails() {
        assertThat(UserDetails.getGuestUserDetails().getUserId(), is(UserId.getGuest()));
    }

    @Test
    public void shouldBeEqualToGuestUser() {
        assertThat(UserDetails.getGuestUserDetails(), is(new UserDetails(UserId.getGuest(), "Guest",
                Optional.empty())));
    }

}