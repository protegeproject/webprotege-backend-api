package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.util.function.Consumer;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-20
 */
@JsonSubTypes({
        @JsonSubTypes.Type(AddEdge.class),
        @JsonSubTypes.Type(RemoveEdge.class)
})
public abstract class EdgeChange<U> extends GraphModelChange<U> {


    private GraphEdge<U> edge;

    protected EdgeChange() {

    }

    protected EdgeChange(GraphEdge<U> edge) {
        this.edge = edge;
    }

    @JsonIgnore
    public GraphNode<U> getPredecessor() {
        return edge.getPredecessor();
    }

    @JsonIgnore
    public GraphNode<U> getSuccessor() {
        return edge.getSuccessor();
    }

    public GraphEdge<U> getEdge() {
        return edge;
    }

    @Override
    void forEachGraphNode(Consumer<GraphNode<U>> nodeConsumer) {
        nodeConsumer.accept(edge.getPredecessor());
        nodeConsumer.accept(edge.getSuccessor());
    }
}
