package edu.stanford.protege.webprotege.project;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 1 Mar 2018
 */
public record SetProjectPrefixDeclarationsResult(@Nonnull ProjectId projectId,
                                                @Nonnull List<PrefixDeclaration> prefixDeclarations) implements Result {

}
