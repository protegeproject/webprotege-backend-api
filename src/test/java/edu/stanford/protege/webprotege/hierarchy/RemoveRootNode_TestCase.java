package edu.stanford.protege.webprotege.hierarchy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(MockitoExtension.class)
public class RemoveRootNode_TestCase<T extends Serializable> {

    @Mock
    private GraphNode<T> node;

    @Test
    public void equalsShouldReturnTrueForEqualNodes() {
        RemoveRootNode<T> removeRootNodeA = new RemoveRootNode<>(node);
        RemoveRootNode<T> removeRootNodeB = new RemoveRootNode<>(node);
        assertThat(removeRootNodeA, equalTo(removeRootNodeB));
    }

    @Test
    public void hashCodeShouldReturnTrueForEqualNodes() {
        RemoveRootNode<T> removeRootNodeA = new RemoveRootNode<>(node);
        RemoveRootNode<T> removeRootNodeB = new RemoveRootNode<>(node);
        assertThat(removeRootNodeA.hashCode(), equalTo(removeRootNodeB.hashCode()));
    }

    @Test
    public void equalToNullShouldReturnFalse() {
        RemoveRootNode<T> removeRootNode = new RemoveRootNode<>(node);
        assertThat(removeRootNode.equals(null), equalTo(false));
    }
}
