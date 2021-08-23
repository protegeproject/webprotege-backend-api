package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 25/03/2013
 */
@JsonTypeName("CreateObjectProperties")
public record CreateObjectPropertiesAction(@Nonnull ProjectId projectId,
                                                   @Nonnull String sourceText,
                                                   @Nonnull String langTag,
                                                   @Nonnull ImmutableSet<OWLObjectProperty> parents) implements Action<CreateObjectPropertiesResult> {

    public static final String CHANNEL = "webprotege.entities.CreateObjectProperties";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
