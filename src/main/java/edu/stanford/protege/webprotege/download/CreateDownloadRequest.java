package edu.stanford.protege.webprotege.download;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import edu.stanford.protege.webprotege.revision.RevisionNumber;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-23
 */
public record CreateDownloadRequest(ProjectId projectId,
                                    RevisionNumber revisionNumber,
                                    DownloadFormat downloadFormat,
                                    String fileName) implements Request<CreateDownloadResponse> {

    public static final String CHANNEL = "downloads.CreateDownload";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
