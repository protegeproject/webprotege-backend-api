package edu.stanford.protege.webprotege.form;


import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.match.criteria.CompositeRootCriteria;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-01-16
 */
public record SetEntityFormDescriptorAction(@Nonnull ProjectId projectId,
                                           @Nonnull FormDescriptor formDescriptor,
                                           @Nonnull FormPurpose purpose,
                                           @Nullable CompositeRootCriteria selectorCriteria) implements ProjectAction<SetEntityFormDescriptorResult> {

}
