package edu.stanford.protege.webprotege.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-15
 */


@JsonTypeName("DeleteForm")
public record DeleteFormAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                               @JsonProperty("formId") @Nonnull FormId formId) implements ProjectAction<DeleteFormResult> {

}
