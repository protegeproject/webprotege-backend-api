package edu.stanford.protege.webprotege.mail;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 06/11/2013
 */
@JsonTypeName("webprotege.users.SetEmailAddress")
public record SetEmailAddressResult(Result result) implements Result {

    public enum Result {
        /**
         * The address was changed.
         */
        ADDRESS_CHANGED,
        /**
         * The user and the address are the same, therefore the address has not been changed.
         */
        ADDRESS_UNCHANGED,
        /**
         * A different user with the specified address exists and the address was not changed.
         */
        ADDRESS_ALREADY_EXISTS
    }
}
