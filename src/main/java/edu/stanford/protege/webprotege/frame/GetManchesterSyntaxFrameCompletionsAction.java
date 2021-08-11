package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.HasSubject;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.mansyntax.EditorPosition;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Set;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 20/03/2014
 */


@JsonTypeName("GetManchesterSyntaxFrameCompletions")
public record GetManchesterSyntaxFrameCompletionsAction(@JsonProperty("projectId") ProjectId projectId,
                                                        @JsonProperty("subject") OWLEntity subject,
                                                        @JsonProperty("syntax") String syntax,
                                                        @JsonProperty("fromPos") EditorPosition fromPos,
                                                        @JsonProperty("from") int from,
                                                        @JsonProperty("freshEntities") Set<OWLEntityData> freshEntities,
                                                        @JsonProperty("entityTypeSuggestionLimit") int entityTypeSuggestLimit) implements ProjectAction<GetManchesterSyntaxFrameCompletionsResult>, HasSubject<OWLEntity> {
}
