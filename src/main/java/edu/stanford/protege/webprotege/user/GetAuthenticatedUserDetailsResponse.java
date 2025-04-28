package edu.stanford.protege.webprotege.user;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.authorization.Capability;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Collection;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-10-29
 */
@JsonTypeName("webprotege.users.GetAuthenticatedUserDetails")
public record GetAuthenticatedUserDetailsResponse(UserDetails userDetails,
                                                  Collection<Capability> permittedActions) implements Result {

}
