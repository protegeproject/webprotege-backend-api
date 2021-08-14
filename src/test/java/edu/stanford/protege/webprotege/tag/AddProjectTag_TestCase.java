package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.color.Color;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.dispatch.Result;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-05
 */
public class AddProjectTag_TestCase {

    @Test
    public void shouldSerializeAddProjectTagAction() throws IOException {
        var action = AddProjectTagAction.create(ProjectId.generate(),
                                                "TheLabel",
                                                "TheDescription",
                                                Color.getWhite(),
                                                Color.get(240, 230, 50));

    }

    @Test
    public void shouldSerializeAddProjectTagResult() throws IOException {
        var result = AddProjectTagResult.create(
                Tag.get(TagId.createTagId(),
                        ProjectId.generate(),
                        "TheLabel",
                        "TheDescription",
                        Color.getWhite(),
                        Color.getWhite(),
                        Collections.emptyList())
        );

    }
}
