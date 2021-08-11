package edu.stanford.protege.webprotege.itemlist;

import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.sharing.PersonId;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 13/05/15
 */
public record GetPersonIdItemsResult(List<PersonId> items) implements Result {

}
