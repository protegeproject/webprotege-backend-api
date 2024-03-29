package edu.stanford.protege.webprotege.issues.mention;


import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.issues.Mention;

import javax.annotation.Nonnull;
import java.util.Optional;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Sep 16
 */
public class UserIdMention extends Mention {

    @Nonnull
    private UserId userId;


    public UserIdMention(@Nonnull UserId userId) {
        this.userId = userId;
    }


    private UserIdMention() {
    }

    @Nonnull
    public UserId getUserId() {
        return userId;
    }

    /**
     * If this mention mentions a UserId then this method returns the UserId.
     *
     * @return The UserId.
     */
    @Nonnull
    @Override
    public Optional<UserId> getMentionedUserId() {
        return Optional.of(userId);
    }

    @Override
    public String toString() {
        return toStringHelper("UserIdMention")
                .addValue(userId)
                .toString();
    }
}
