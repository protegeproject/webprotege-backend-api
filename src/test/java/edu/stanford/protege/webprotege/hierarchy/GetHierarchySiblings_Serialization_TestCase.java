package edu.stanford.protege.webprotege.hierarchy;

import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClass;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public abstract class GetHierarchySiblings_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetHierarchySiblingsAction(ProjectId.generate(),
                                                       mockOWLClass(),
                                                       ClassHierarchyDescriptor.create(),
                                                       PageRequest.requestFirstPage());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetHierarchySiblingsResult(Page.emptyPage());

    }
}