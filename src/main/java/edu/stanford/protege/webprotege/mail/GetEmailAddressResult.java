package edu.stanford.protege.webprotege.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.user.EmailAddress;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 06/11/2013
 * <p>
 *     The result from a {@link GetEmailAddressAction}.
 * </p>
 */


@JsonTypeName("webprotege.users.GetEmailAddress")
public record GetEmailAddressResult(@JsonProperty("userId") UserId userId,
                                    @JsonProperty("emailAddress") @Nullable EmailAddress emailAddress) implements Result {

    /**
     * Gets the {@link EmailAddress}.
     * @return The {@link EmailAddress}.  An absent value indicates that the email for the specified user id
     * does not exist.  Not {@code null}.
     */
    public Optional<EmailAddress> getEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }


}
