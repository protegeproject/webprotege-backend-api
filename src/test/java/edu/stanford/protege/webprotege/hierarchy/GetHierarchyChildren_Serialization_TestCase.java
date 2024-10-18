package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClass;
import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClassNode;
import static org.mockito.Mockito.mock;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetHierarchyChildren_Serialization_TestCase {

    private JacksonTester<GetHierarchyChildrenAction> tester;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, ObjectMapper::new);
    }

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetHierarchyChildrenAction(ProjectId.generate(),
                                                       mockOWLClass(),
                                                       ClassHierarchyDescriptor.create(),
                                                       PageRequest.requestFirstPage());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetHierarchyChildrenResult(GraphNode.get(mockOWLClassNode(), true),
                                                       Page.emptyPage());
        
    }
}