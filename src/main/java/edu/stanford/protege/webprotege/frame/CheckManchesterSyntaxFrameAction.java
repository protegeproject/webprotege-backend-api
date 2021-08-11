package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.HasSubject;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
@JsonTypeName("CheckManchesterSyntax")
public record CheckManchesterSyntaxFrameAction(ProjectId projectId,
                                               OWLEntity subject,
                                               String from,
                                               String to,
                                               ImmutableSet<OWLEntityData> freshEntities)implements ProjectAction<CheckManchesterSyntaxFrameResult>, HasSubject<OWLEntity> {


    @JsonCreator
    public static CheckManchesterSyntaxFrameAction create(@JsonProperty("projectId") ProjectId projectId,
                                                   @JsonProperty("subject") OWLEntity subject,
                                                   @JsonProperty("from") String from,
                                                   @JsonProperty("to") String to,
                                                   @JsonProperty("freshEntities") ImmutableSet<OWLEntityData> freshEntities) {
        return new CheckManchesterSyntaxFrameAction(projectId, subject, from, to, freshEntities);
    }

    @Override
    public OWLEntity subject() {
        return subject;
    }
}
