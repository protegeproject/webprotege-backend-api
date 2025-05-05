package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-30
 */
public class PerspectiveLayoutRecord_Serialization_TestCase {

    @Test
    public void shouldSerializeRecordWithoutUserId() throws IOException {
        var record = PerspectiveLayoutRecord.get(ProjectId.generate(), null, PerspectiveId.generate(), null);

    }

    @Test
    public void shouldSerializeRecordWithUserId() throws IOException {
        var record = PerspectiveLayoutRecord.get(ProjectId.generate(), UserId.valueOf("Matthew"), PerspectiveId.generate(), null);

    }
}
