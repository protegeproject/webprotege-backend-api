package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.owlapi.RenameMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-08-29
 */
@RunWith(MockitoJUnitRunner.class)
public class ChangeApplicationResult_TestCase<S> {

    private ChangeApplicationResult<S> result;

    @Mock
    private S subject;

    @Mock
    private OntologyChange change;

    private List<OntologyChange> changeList;

    private RenameMap renameMap = new RenameMap(Map.of());

    @Before
    public void setUp() {
        changeList = Collections.singletonList(change);
        result = new ChangeApplicationResult<>(subject,
                                               changeList,
                                               renameMap);
    }

    @Test
    public void shouldGetSuppliedSubject() {
        assertThat(result.subject(), is(subject));
    }

    @Test
    public void shouldGetSuppliedChangeList() {
        assertThat(result.getChangeList(), is(changeList));
    }

    @Test
    public void shouldGetSuppliedRenameMap() {
        assertThat(result.getRenameMap(), is(renameMap));
    }
}
