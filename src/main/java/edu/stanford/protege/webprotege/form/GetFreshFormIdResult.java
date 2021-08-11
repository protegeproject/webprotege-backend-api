package edu.stanford.protege.webprotege.form;

import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.project.HasProjectId;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-01-16
 */


public record GetFreshFormIdResult(@Nonnull ProjectId projectId,
                                   @Nonnull FormId formId) implements Result {
}
