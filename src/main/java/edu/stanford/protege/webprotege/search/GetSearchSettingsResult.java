package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-17
 */


@JsonTypeName("webprotege.search.GetSearchSettings")
public record GetSearchSettingsResult(@JsonProperty("filters") @Nonnull ImmutableList<EntitySearchFilter> filters) implements Result {

}
