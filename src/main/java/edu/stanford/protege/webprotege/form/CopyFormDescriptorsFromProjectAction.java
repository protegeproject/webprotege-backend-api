package edu.stanford.protege.webprotege.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-14
 */


@JsonTypeName("CopyFormDescriptorsFromProject")
public record CopyFormDescriptorsFromProjectAction(@JsonProperty("projectId") ProjectId projectId,
                                                   @JsonProperty("projectIdToCopyFrom") ProjectId newProjectIdToCopyFrom,
                                                   @JsonProperty("formIdsToCopy") ImmutableList<FormId> newFormIdsToCopy) implements ProjectAction<CopyFormDescriptorsFromProjectResult> {


}
