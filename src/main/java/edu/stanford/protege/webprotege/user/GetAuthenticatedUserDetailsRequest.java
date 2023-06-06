package edu.stanford.protege.webprotege.user;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-10-29
 *
 * Gets the details for the user making this request
 */
@JsonTypeName("webprotege.users.GetAuthenticatedUserDetails")
public record GetAuthenticatedUserDetailsRequest() implements Action<GetAuthenticatedUserDetailsResponse> {

    public static final String CHANNEL = "webprotege.users.GetAuthenticatedUserDetails";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
