package edu.stanford.protege.webprotege.usage;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.PageRequest;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.AxiomType;

import java.io.IOException;
import java.util.Optional;

import static edu.stanford.protege.webprotege.MockingUtils.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetUsage_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetEntityUsageAction(mockOWLClass(), mockProjectId(), new UsageFilter(), PageRequest.requestFirstPage());

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetEntityUsageResult(mockProjectId(),
                mockOWLClassNode(),
                ImmutableList.of(
                        new UsageReference(AxiomType.DECLARATION,
                                "Declaration(Class(http://example.org/A))",
                                Optional.empty(),
                                Optional.empty()
                        )
                ), 22);

    }
}