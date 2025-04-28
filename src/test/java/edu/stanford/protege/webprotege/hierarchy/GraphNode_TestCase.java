package edu.stanford.protege.webprotege.hierarchy;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.MockingUtils;
import edu.stanford.protege.webprotege.entity.EntityNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.Serializable;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class GraphNode_TestCase<T extends Serializable> {

    @Mock
    private T userObject;

    @Mock
    private T otherUserObject;

    @Test
    public void shouldReturnEqualForNodesWithEqualUserObjects() {
        GraphNode<T> nodeA = new GraphNode<>(userObject, false);
        GraphNode<T> nodeB = new GraphNode<>(userObject, false);
        assertEquals(nodeA, nodeB);
    }

    @Test
    public void shouldReturnEqualHashCodesForNodesWithEqualUserObjects() {
        GraphNode<T> nodeA = new GraphNode<>(userObject, false);
        GraphNode<T> nodeB = new GraphNode<>(userObject, false);
        assertEquals(nodeA.hashCode(), nodeB.hashCode());
    }

    @Test
    public void shouldReturnEqualForNodesWithEqualUserObjectsButDifferentSinkFlags() {
        GraphNode<T> nodeA = new GraphNode<>(userObject, false);
        GraphNode<T> nodeB = new GraphNode<>(userObject, true);
        assertEquals(nodeA, nodeB);
    }

    @Test
    public void shouldReturnNotEqualForNodesWithDifferentUserObjects() {
        GraphNode<T> nodeA = new GraphNode<>(userObject, false);
        GraphNode<T> nodeB = new GraphNode<>(otherUserObject, false);
        assertNotEquals(nodeA, nodeB);
    }

    @Test
    public void shouldReturnFalseForEqualsCalledWithNullArgument() {
        GraphNode<T> node = new GraphNode<>(userObject);
        assertNotEquals(null, node);
    }

    @Test
    public void isSinkShouldReturnSuppliedSinkFlag() {
        GraphNode<T> node = new GraphNode<>(userObject, true);
        assertTrue(node.isSink());
    }

    @Test
    public void shouldSerializeAsJson() throws IOException {
        var graphNode = new GraphNode<>(EntityNode.get(MockingUtils.mockOWLClass(),
                "Hello",
                ImmutableList.of(),
                true, ImmutableSet.of(),
                3,
                ImmutableSet.of(),
                ImmutableSet.of()));

    }
}
