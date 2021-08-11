package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Mar 2018
 */
public record UpdateEntityTagsAction(@Nonnull ProjectId projectId,
                                    @Nonnull OWLEntity entity,
                                    @Nonnull Set<TagId> fromTagIds,
                                    @Nonnull Set<TagId> toTagIds) implements ProjectAction<UpdateEntityTagsResult> {
}
