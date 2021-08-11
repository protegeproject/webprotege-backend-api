package edu.stanford.protege.webprotege.itemlist;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 13/05/15
 */
public record GetPersonIdItemsAction(ProjectId projectId, List<String> itemNames) implements ProjectAction<GetPersonIdItemsResult> {

}
