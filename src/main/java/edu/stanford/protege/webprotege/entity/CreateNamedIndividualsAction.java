package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 12/09/2013
 */
@JsonTypeName("CreateNamedIndividuals")
public record CreateNamedIndividualsAction(@Nonnull ProjectId projectId,
                                                   @Nonnull String sourceText,
                                                   @Nonnull String langTag,
                                                   @Nonnull ImmutableSet<OWLClass> types) implements ProjectAction<CreateNamedIndividualsResult> {

}
