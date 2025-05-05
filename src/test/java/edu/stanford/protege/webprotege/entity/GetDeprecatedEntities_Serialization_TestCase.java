package edu.stanford.protege.webprotege.entity;

import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.EntityType;

import java.io.IOException;
import java.util.Collections;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
public class GetDeprecatedEntities_Serialization_TestCase {


    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetDeprecatedEntitiesAction(ProjectId.generate(),
                PageRequest.requestFirstPage(),
                Collections.singleton(EntityType.CLASS));

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetDeprecatedEntitiesResult(Page.emptyPage());

    }
}
