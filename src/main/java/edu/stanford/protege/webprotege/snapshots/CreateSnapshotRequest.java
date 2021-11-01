package edu.stanford.protege.webprotege.snapshots;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.DocumentFormat;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import edu.stanford.protege.webprotege.download.DownloadFormat;
import edu.stanford.protege.webprotege.revision.RevisionNumber;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-23
 */
@JsonTypeName("webprotege.snapshots.CreateSnapshot")
public record CreateSnapshotRequest(ProjectId projectId,
                                    RevisionNumber revisionNumber,
                                    DocumentFormat documentFormat,
                                    String fileName) implements Request<CreateSnapshotResponse> {

    public static final String CHANNEL = "webprotege.snapshots.CreateSnapshot";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
