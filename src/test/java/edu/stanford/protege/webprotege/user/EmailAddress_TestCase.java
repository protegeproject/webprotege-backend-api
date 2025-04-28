package edu.stanford.protege.webprotege.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class EmailAddress_TestCase {

    private final String address = "x@y.com";

    private EmailAddress emailAddress;

    @BeforeEach
    public void setUp() {
        emailAddress = new EmailAddress(address);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_address_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new EmailAddress(null);
        });
    }

    @Test
    public void shouldReturnSupplied_address() {
        assertThat(emailAddress.getEmailAddress(), is(this.address));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(emailAddress, is(emailAddress));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(emailAddress.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(emailAddress, is(new EmailAddress(address)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_address() {
        assertThat(emailAddress, is(not(new EmailAddress("String-de67417b-eb48-4ebc-a141-08e715a54719"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(emailAddress.hashCode(), is(new EmailAddress(address).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(emailAddress.toString(), startsWith("EmailAddress"));
    }

    @Test
    public void shouldReturn_true_For_isEmpty() {
        EmailAddress emailAddress = new EmailAddress("");
        assertThat(emailAddress.isEmpty(), is(true));
    }

    @Test
    public void shouldReturn_false_For_isEmpty() {
        assertThat(emailAddress.isEmpty(), is(false));
    }

    @Test
    public void should_getEmailAddress() {
        assertThat(emailAddress.getEmailAddress(), is(address));
    }

}
