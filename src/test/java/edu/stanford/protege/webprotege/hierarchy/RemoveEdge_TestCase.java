package edu.stanford.protege.webprotege.hierarchy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(MockitoExtension.class)
public class RemoveEdge_TestCase<T extends Serializable> {

    @Mock
    private GraphEdge<T> edge;

    @Test
    public void equalsShouldReturnTrueForEqualEdges() {
        RemoveEdge<T> removeEdgeA = new RemoveEdge<>(edge);
        RemoveEdge<T> removeEdgeB = new RemoveEdge<>(edge);
        assertThat(removeEdgeA, equalTo(removeEdgeB));
    }

    @Test
    public void hashCodeShouldReturnTrueForEqualEdges() {
        RemoveEdge<T> removeEdgeA = new RemoveEdge<>(edge);
        RemoveEdge<T> removeEdgeB = new RemoveEdge<>(edge);
        assertThat(removeEdgeA.hashCode(), equalTo(removeEdgeB.hashCode()));
    }

    @Test
    public void equalToNullShouldReturnFalse() {
        RemoveEdge<T> removeEdge = new RemoveEdge<>(edge);
        assertThat(removeEdge.equals(null), equalTo(false));
    }
}
