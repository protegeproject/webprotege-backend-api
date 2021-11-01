package edu.stanford.protege.webprotege.merge_add;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;



@JsonTypeName("webprotege.uploads.GetUploadedOntologies")
public record GetUploadedOntologiesAction(@JsonProperty("projectId") ProjectId projectId,
                                          @JsonProperty("documentId") DocumentId documentId) implements ProjectAction<GetUploadedOntologiesResult> {

    public static final String CHANNEL = "webprotege.uploads.GetUploadedOntologies";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
