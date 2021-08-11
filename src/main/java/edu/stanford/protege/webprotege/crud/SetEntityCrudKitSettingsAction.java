package edu.stanford.protege.webprotege.crud;

import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 8/19/13
 */
public record SetEntityCrudKitSettingsAction(ProjectId projectId, EntityCrudKitSettings fromSettings, EntityCrudKitSettings toSettings, IRIPrefixUpdateStrategy prefixUpdateStrategy) implements ProjectAction<SetEntityCrudKitSettingsResult> {

}
