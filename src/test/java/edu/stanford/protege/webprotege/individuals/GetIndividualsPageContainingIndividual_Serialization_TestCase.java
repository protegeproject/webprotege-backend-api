package edu.stanford.protege.webprotege.individuals;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.EntityNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static edu.stanford.protege.webprotege.MockingUtils.mockOWLClassData;
import static edu.stanford.protege.webprotege.MockingUtils.mockOWLNamedIndividual;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetIndividualsPageContainingIndividual_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetIndividualsPageContainingIndividualAction(ProjectId.generate(),
                mockOWLNamedIndividual(), Optional.empty(),
                InstanceRetrievalMode.ALL_INSTANCES);

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetIndividualsPageContainingIndividualResult(mockOWLNamedIndividual(),
                Page.emptyPage(), EntityNode.getFromEntityData(mockOWLClassData()),
                InstanceRetrievalMode.ALL_INSTANCES,
                ImmutableSet.of());

    }
}