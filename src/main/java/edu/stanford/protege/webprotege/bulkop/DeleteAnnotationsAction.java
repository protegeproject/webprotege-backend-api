package edu.stanford.protege.webprotege.bulkop;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Sep 2018
 */
@Deprecated
public record DeleteAnnotationsAction(ProjectId projectId,
                                      ImmutableSet<OWLEntity> entities,
                                      AnnotationSimpleMatchingCriteria criteria) implements ProjectAction<DeleteAnnotationsResult> {

    public static final String CHANNEL = "webprotege.bulkop.DeleteAnnotations";

    public DeleteAnnotationsAction(@Nonnull ProjectId projectId,
                                   @Nonnull ImmutableSet<OWLEntity> entities,
                                   @Nonnull AnnotationSimpleMatchingCriteria criteria) {
        this.projectId = checkNotNull(projectId);
        this.entities = checkNotNull(entities);
        this.criteria = checkNotNull(criteria);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
