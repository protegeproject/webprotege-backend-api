package edu.stanford.protege.webprotege.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 04/04/2013
 * <p>
 *     Represents the key details about a user.
 * </p>
 */
public class UserDetails implements Serializable {

    private static final String GUEST_DISPLAY_NAME = "Guest";

    private static final UserDetails GUEST_DETAILS = new UserDetails(UserId.getGuest(), GUEST_DISPLAY_NAME, Optional.empty());

    private final UserId userId;

    private final String displayName;

    private final String emailAddress;


    /**
     * Constructs a {@link UserDetails} object representing the key details about a user.
     * @param userId The {@link UserId} of that identifies the user.  Not {@code null}.
     * @param displayName The display name of the user.  Not {@code null}.
     * @param emailAddress The email address of the user.  Not {@code null}.
     * @throws NullPointerException if any parameter is {@code null}.
     */
    public UserDetails(@Nonnull UserId userId,
                       @Nonnull String displayName,
                       @Nonnull Optional<String> emailAddress) {
        this.userId = checkNotNull(userId);
        this.displayName = checkNotNull(displayName);
        this.emailAddress = emailAddress.orElse(null);
    }

    /**
     * Constructs a {@link UserDetails} object representing the key details about a user.
     * @param userId The {@link UserId} of that identifies the user.  Not {@code null}.
     * @param displayName The display name of the user.  Not {@code null}.
     * @param emailAddress The email address of the user.  Not {@code null}.
     * @throws NullPointerException if any parameter is {@code null}.
     */
    @Nonnull
    public static UserDetails getUserDetails(@Nonnull UserId userId,
                                             @Nonnull String displayName,
                                             @Nonnull String emailAddress) {
        return new UserDetails(userId, displayName, Optional.of(emailAddress));
    }

    @Nonnull
    @JsonCreator
    public static UserDetails getUserDetails(@JsonProperty("userId") @Nonnull UserId userId,
                                             @JsonProperty("displayName") @Nonnull String displayName,
                                             @JsonProperty("emailAddress") @Nonnull Optional<String> emailAddress) {
        return new UserDetails(userId, displayName, emailAddress);
    }

    @Nonnull
    public static UserDetails getGuestUserDetails() {
        return GUEST_DETAILS;
    }


    /**
     * Gets the {@link UserId} that identifies the user that these details pertain to.
     * @return The {@link UserId}.  Not {@code null}.
     */
    @Nonnull
    public UserId getUserId() {
        return userId;
    }

    /**
     * Gets the display name for the user.
     * @return A String representing the display name.  Not {@code null}.
     */
    @Nonnull
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets the email address for the user.
     * @return The {@link EmailAddress}.  Not {@code null}.
     */
    @Nonnull
    public Optional<String> getEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(userId, displayName, emailAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) obj;
        return this.userId.equals(other.userId) && this.displayName.equals(other.displayName) && this.getEmailAddress().equals(other.getEmailAddress());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("UserDetails")
                          .addValue(userId)
                          .add("displayName", displayName)
                          .add("emailAddress", Optional.ofNullable(emailAddress).orElse(""))
                          .toString();
    }
}
