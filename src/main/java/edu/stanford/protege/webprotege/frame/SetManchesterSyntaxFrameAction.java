package edu.stanford.protege.webprotege.frame;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.HasSubject;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
public record SetManchesterSyntaxFrameAction(ProjectId projectId,
                                            OWLEntity subject,
                                            String fromRendering,
                                            String toRendering,
                                            Set<OWLEntityData> freshEntities,
                                            String commitMessage) implements ProjectAction<SetManchesterSyntaxFrameResult> {

}


