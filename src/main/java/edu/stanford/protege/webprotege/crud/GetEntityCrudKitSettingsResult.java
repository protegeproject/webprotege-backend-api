package edu.stanford.protege.webprotege.crud;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 8/19/13
 */
@JsonTypeName("webprotege.projects.GetEntityCrudKitSettings")
public class GetEntityCrudKitSettingsResult implements Result {

    private EntityCrudKitSettings settings;

    /**
     * For serialization purposes only
     */
    private GetEntityCrudKitSettingsResult() {
    }

    public GetEntityCrudKitSettingsResult(EntityCrudKitSettings settings) {
        this.settings = checkNotNull(settings);
    }

    public EntityCrudKitSettings getSettings() {
        return settings;
    }
}
