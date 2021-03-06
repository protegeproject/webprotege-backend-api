package edu.stanford.protege.webprotege.merge;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26/01/15
 */


@JsonTypeName("webprotege.projects.MergeUploadedProject")
public record MergeUploadedProjectAction(@JsonProperty("changeRequesId") ChangeRequestId changeRequestId,
                                         @JsonProperty("projectId") ProjectId projectId,
                                         @JsonProperty("documentId") DocumentId uploadedDocumentId,
                                         @JsonProperty("commitMessage") String commitMessage) implements ProjectAction<MergeUploadedProjectResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.projects.MergeUploadedProject";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
