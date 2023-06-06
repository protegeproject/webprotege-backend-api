package edu.stanford.protege.webprotege.crud;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
import edu.stanford.protege.webprotege.crud.supplied.SuppliedNameSuffixSettings;
import org.junit.Test;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public abstract class GetEntityCrudKits_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetEntityCrudKitsAction(ProjectId.generate());
        
    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetEntityCrudKitsResult(ImmutableList.of(),
                                                    EntityCrudKitSettings.get(
                                                            EntityCrudKitPrefixSettings.get(),
                                                            SuppliedNameSuffixSettings.get(),
                                                            GeneratedAnnotationsSettings.empty()
                                                    ));
        
    }
}
