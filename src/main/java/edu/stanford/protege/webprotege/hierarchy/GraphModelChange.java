package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.function.Consumer;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-20
 */
@JsonSubTypes({
        @Type(EdgeChange.class),
        @Type(AddRootNode.class),
        @Type(UpdateUserObject.class),
        @Type(RemoveRootNode.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public abstract class GraphModelChange<U> {

    public GraphModelChange() {
    }

    public abstract void accept(GraphModelChangeVisitor<U> visitor);

    abstract void forEachGraphNode(Consumer<GraphNode<U>> nodeConsumer);
}
