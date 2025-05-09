package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetHierarchyRoots_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetHierarchyRootsAction(ProjectId.generate(),
                ClassHierarchyDescriptor.create());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetHierarchyRootsResult(Collections.emptyList());

    }
}