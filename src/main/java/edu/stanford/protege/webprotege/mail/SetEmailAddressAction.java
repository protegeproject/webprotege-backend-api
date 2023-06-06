package edu.stanford.protege.webprotege.mail;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.user.EmailAddress;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 06/11/2013
 * <p>
 *     An action that sets the email address of a user.
 * </p>
 *  Constructs a {@link SetEmailAddressAction} object using the specified email address.
 *   @param userId The {@link UserId} of the user whose email address should be set.  Not {@code null}.
 *     @param emailAddress The email address to set.  Not {@code null}.
 *
 */
@JsonTypeName("webprotege.users.SetEmailAddress")
public record SetEmailAddressAction(UserId userId, EmailAddress emailAddress) implements Action<SetEmailAddressResult> {

    public static final String CHANNEL = "webprotege.users.SetEmailAddress";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
