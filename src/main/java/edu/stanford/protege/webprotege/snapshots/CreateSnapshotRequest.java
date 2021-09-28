package edu.stanford.protege.webprotege.snapshots;

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
public record CreateSnapshotRequest(ProjectId projectId,
                                    RevisionNumber revisionNumber,
                                    DocumentFormat documentFormat,
                                    String fileName) implements Request<CreateSnapshotResponse> {

    public static final String CHANNEL = "snapshots.CreateSnapshot";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
