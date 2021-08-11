package edu.stanford.protege.webprotege.sharing;

import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
public record GetProjectSharingSettingsResult(ProjectSharingSettings settings) implements Result {

}
