package edu.stanford.protege.webprotege.viz;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import org.junit.Test;

import java.io.IOException;

import static edu.stanford.protege.webprotege.MockingUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class SetEntityGraphActiveFilters_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new SetEntityGraphActiveFiltersAction(ChangeRequestId.generate(), mockProjectId(), ImmutableList.of(
                FilterName.get("Hello")
        ));
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new SetEntityGraphActiveFiltersResult();
        
    }
}