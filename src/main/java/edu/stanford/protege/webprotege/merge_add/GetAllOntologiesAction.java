package edu.stanford.protege.webprotege.merge_add;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;



@JsonTypeName("GetAllOntologies")
public record GetAllOntologiesAction(@JsonProperty("projectId") ProjectId projectId,
                                     @JsonProperty("documentId") DocumentId documentId) implements ProjectAction<GetAllOntologiesResult> {
}
