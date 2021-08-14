package edu.stanford.protege.webprotege.mail;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.common.UserId;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 06/11/2013
 */
@JsonTypeName("GetEmailAddress")
public record GetEmailAddressAction(UserId userId) implements Action<GetEmailAddressResult> {

    public static GetEmailAddressAction create(UserId userId) {
        return new GetEmailAddressAction(userId);
    }
}
