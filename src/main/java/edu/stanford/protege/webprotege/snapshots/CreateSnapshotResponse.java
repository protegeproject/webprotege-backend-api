package edu.stanford.protege.webprotege.snapshots;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-09-23
 */
@JsonTypeName("webprotege.snapshots.CreateSnapshot")
public record CreateSnapshotResponse(@JsonProperty("snapshotStorageCoordinates") SnapshotStorageCoordinates snapshotStorageCoordinates) implements Response {

}
