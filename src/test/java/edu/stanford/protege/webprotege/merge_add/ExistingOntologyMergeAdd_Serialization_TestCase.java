package edu.stanford.protege.webprotege.merge_add;

import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.csv.DocumentId;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
public class ExistingOntologyMergeAdd_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new ExistingOntologyMergeAddAction(ChangeRequestId.generate(),
                                                        ProjectId.generate(),
                                                        new DocumentId("abc"),
                                                        Collections.emptyList(),
                                                        MockingUtils.mockOWLOntologyID());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new ExistingOntologyMergeAddResult();

    }
}
