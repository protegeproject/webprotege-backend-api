package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.PageRequest;
import org.semanticweb.owlapi.model.EntityType;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 16 Jun 2017
 */


@JsonTypeName("webprotege.entities.GetDeprecatedEntities")
public record GetDeprecatedEntitiesAction(@JsonProperty(value = "projectId", required = true) @Nonnull ProjectId projectId,
                                          @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest,
                                          @JsonProperty("entityTypes") @Nonnull Set<EntityType<?>> entityTypes) implements ProjectAction<GetDeprecatedEntitiesResult> {

    public static final String CHANNEL = "webprotege.entities.GetDeprecatedEntities";

    public GetDeprecatedEntitiesAction(@JsonProperty(value = "projectId", required = true) @Nonnull ProjectId projectId,
                                       @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest,
                                       @JsonProperty("entityTypes") @Nonnull Set<EntityType<?>> entityTypes) {
        this.projectId = projectId;
        this.pageRequest = Objects.requireNonNullElse(pageRequest, PageRequest.requestFirstPage());
        this.entityTypes = Objects.requireNonNullElse(entityTypes, Collections.emptySet());
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
