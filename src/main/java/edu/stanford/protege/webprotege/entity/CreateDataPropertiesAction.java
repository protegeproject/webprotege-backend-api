package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLDataProperty;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 25/03/2013
 */
@JsonTypeName("webprotege.entities.CreateDataProperties")
public record CreateDataPropertiesAction(@Nonnull ChangeRequestId changeRequestId,
                                         @Nonnull ProjectId projectId,
                                         @Nonnull String sourceText,
                                         @Nonnull String langTag,
                                         ImmutableSet<OWLDataProperty> parents) implements ProjectAction<CreateDataPropertiesResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.entities.CreateDataProperties";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
