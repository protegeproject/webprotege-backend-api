package edu.stanford.protege.webprotege.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import edu.stanford.protege.webprotege.common.*;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableMap.toImmutableMap;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/03/2013
 */
@JsonTypeName("webprotege.entities.events.BrowserTextChanged")
public record BrowserTextChangedEvent(@JsonProperty("projectId") ProjectId projectId,
                                      @JsonProperty("entity") OWLEntity entity,
                                      @JsonProperty("newBrowserText") String newBrowserText,
                                      @JsonProperty("shortForms") ImmutableList<ShortForm> shortForms) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.entities.events.BrowserTextChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
