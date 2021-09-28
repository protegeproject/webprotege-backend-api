package edu.stanford.protege.webprotege.snapshots;

import edu.stanford.protege.webprotege.common.Response;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-23
 */
public record CreateSnapshotResponse(SnapshotStorageCoordinates snapshotStorageCoordinates) implements Response {

}
