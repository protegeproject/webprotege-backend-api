package edu.stanford.protege.webprotege.snapshots;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.DocumentFormat;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.revision.RevisionNumber;

import static edu.stanford.protege.webprotege.snapshots.CreateSnapshotRequest.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-23
 */
@JsonTypeName(CHANNEL)
public record CreateSnapshotRequest(@JsonProperty("projectId") ProjectId projectId,
                                    @JsonProperty("revisionNumber") RevisionNumber revisionNumber,
                                    @JsonProperty("documentFormat") DocumentFormat documentFormat,
                                    @JsonProperty("fileName") String fileName) implements ProjectRequest<CreateSnapshotResponse> {

    public static final String CHANNEL = "webprotege.snapshots.CreateSnapshot";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
