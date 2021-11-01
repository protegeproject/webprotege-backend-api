package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 12/11/2013
 */
/**
 * Creates a LookupEntitiesAction to perform the specified lookup in the specified project.
 * @param projectId The {@link ProjectId} that identifies the project which entities should be looked up in.  Not {@code null}.
 * @param entityLookupRequest The lookup request. Not {@code null}.
 * @throws  NullPointerException if any parameters are {@code null}.
 */
@JsonTypeName("webprotege.entities.LookupEntities")
public record LookupEntitiesAction(ProjectId projectId, EntityLookupRequest entityLookupRequest) implements ProjectAction<LookupEntitiesResult> {

    public static final String CHANNEL = "webprotege.entities.LookupEntities";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
