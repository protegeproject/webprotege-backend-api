package edu.stanford.protege.webprotege.app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.authorization.api.ActionId;
import edu.stanford.protege.webprotege.user.UserDetails;

import javax.annotation.Nonnull;

import java.util.Set;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 29/12/14
 *
 * Represents a user in the current session
 */
public class UserInSession {

    private UserDetails userDetails;

    private ImmutableSet<ActionId> allowedApplicationActions;

    /**
     * For serialization
     */

    private UserInSession() {
    }

    @JsonCreator
    public UserInSession(@JsonProperty("userDetails") @Nonnull UserDetails userDetails,
                         @JsonProperty("allowedApplicationActions") @Nonnull Set<ActionId> allowedApplicationActions) {
        this.userDetails = checkNotNull(userDetails);
        this.allowedApplicationActions = ImmutableSet.copyOf(checkNotNull(allowedApplicationActions));
    }

    @Nonnull
    public UserDetails getUserDetails() {
        return userDetails;
    }

    /**
     * Gets the allowed application actions.  That is, the actions that can be performed at an application level.
     * @return A set of action ids representing the allowed application actions.
     */
    @Nonnull
    public Set<ActionId> getAllowedApplicationActions() {
        return allowedApplicationActions;
    }

    /**
     * Determines if the user is the guest user
     * @return true if the user is the guest user, otherwise false
     */
    public boolean isGuest() {
        return userDetails.getUserId().isGuest();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userDetails, allowedApplicationActions);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserInSession)) {
            return false;
        }
        UserInSession other = (UserInSession) obj;
        return userDetails.equals(other.userDetails)
                && allowedApplicationActions.equals(other.allowedApplicationActions);
    }


    @Override
    public String toString() {
        return toStringHelper("UserInSession")
                .addValue(userDetails)
                .add("allowedApplicationActions", allowedApplicationActions)
                .toString();
    }

    public boolean isAllowedApplicationAction(@Nonnull ActionId actionId) {
        return allowedApplicationActions.contains(actionId);
    }
}
