package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 22/02/2013
 */
@JsonTypeName("CreateClasses")
public record CreateClassesAction(ProjectId projectId,
                                  String sourceText,
                                  String langTag,
                                  ImmutableSet<OWLClass> parents) implements ProjectAction<CreateClassesResult>, Request<CreateClassesResult> {

    public static final String CHANNEL = "webprotege.entities.CreateClasses";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
