package edu.stanford.protege.webprotege.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.project.HasProjectId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-11-20
 */


@JsonTypeName("GetProjectFormDescriptors")
public record GetProjectFormDescriptorsResult(@Nonnull ProjectId projectId,
                                              @Nonnull ImmutableList<FormDescriptor> formDescriptors,
                                              @Nonnull ImmutableList<EntityFormSelector> formSelectors) implements Result, HasProjectId {

    @NotNull
    @Override
    public ProjectId getProjectId() {
        return projectId;
    }
}
