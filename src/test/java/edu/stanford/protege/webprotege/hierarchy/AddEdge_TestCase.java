package edu.stanford.protege.webprotege.hierarchy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(MockitoExtension.class)
public class AddEdge_TestCase<T extends Serializable> {

    @Mock
    private GraphEdge<T> edge;

    @Test
    public void equalsShouldReturnTrueForEqualEdges() {
        AddEdge<T> addEdgeA = new AddEdge<>(edge);
        AddEdge<T> addEdgeB = new AddEdge<>(edge);
        assertThat(addEdgeA, equalTo(addEdgeB));
    }

    @Test
    public void hashCodeShouldReturnTrueForEqualEdges() {
        AddEdge<T> addEdgeA = new AddEdge<>(edge);
        AddEdge<T> addEdgeB = new AddEdge<>(edge);
        assertThat(addEdgeA.hashCode(), equalTo(addEdgeB.hashCode()));
    }

    @Test
    public void equalToNullShouldReturnFalse() {
        AddEdge<T> addEdge = new AddEdge<>(edge);
        assertThat(addEdge.equals(null), equalTo(false));
    }
}
