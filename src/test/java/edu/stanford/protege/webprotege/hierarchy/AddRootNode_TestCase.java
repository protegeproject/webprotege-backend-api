package edu.stanford.protege.webprotege.hierarchy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.Serializable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(MockitoExtension.class)
public class AddRootNode_TestCase<T extends Serializable> {

    @Mock
    private GraphNode<T> node;

    @Test
    public void equalsShouldReturnTrueForEqualNodes() {
        AddRootNode<T> addRootNodeA = new AddRootNode<>(node);
        AddRootNode<T> addRootNodeB = new AddRootNode<>(node);
        assertThat(addRootNodeA, equalTo(addRootNodeB));
    }

    @Test
    public void hashCodeShouldReturnTrueForEqualNodes() {
        AddRootNode<T> addRootNodeA = new AddRootNode<>(node);
        AddRootNode<T> addRootNodeB = new AddRootNode<>(node);
        assertThat(addRootNodeA.hashCode(), equalTo(addRootNodeB.hashCode()));
    }

    @Test
    public void equalToNullShouldReturnFalse() {
        AddRootNode<T> addRootNode = new AddRootNode<>(node);
        assertThat(addRootNode.equals(null), equalTo(false));
    }

    @Test
    public void shouldSerializeAsJson() throws IOException {

    }
}
