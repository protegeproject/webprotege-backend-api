package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClass;
import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClassNode;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetHierarchyChildren_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetHierarchyChildrenAction(ProjectId.generate(),
                                                       mockOWLClass(),
                                                       HierarchyId.CLASS_HIERARCHY,
                                                       PageRequest.requestFirstPage());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetHierarchyChildrenResult(GraphNode.get(mockOWLClassNode(), true),
                                                       Page.emptyPage());
        
    }
}