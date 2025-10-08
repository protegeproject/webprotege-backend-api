package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
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
@JsonTypeName("webprotege.entities.CreateClasses")
@JsonClassDescription("Represents a request to create OWL classes in a specified project")
public record CreateClassesAction(ChangeRequestId changeRequestId,
                                  @JsonPropertyDescription("The id of the project where the classes will be created")
                                  ProjectId projectId,
                                  @JsonPropertyDescription("""
                                          The source text that contains the user supplied names for the classes.

                                          Multiple user-supplied class names should be separated with a new line.""")
                                  String sourceText,
                                  @JsonPropertyDescription("The language tag that should be used for the labels of the created classes")
                                  String langTag,
                                  @JsonPropertyDescription("""
                                          A set of classes that the created classes will be subclasses of.

                                          May be empty.""")
                                  ImmutableSet<OWLClass> parents) implements ProjectAction<CreateClassesResult>, Request<CreateClassesResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.entities.CreateClasses";

    public CreateClassesAction {
        if(changeRequestId == null) {
            changeRequestId = ChangeRequestId.generate();
        }
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
