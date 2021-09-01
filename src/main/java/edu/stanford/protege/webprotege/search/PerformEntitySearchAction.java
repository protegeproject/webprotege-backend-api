package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.LangTagFilter;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.project.HasProjectId;
import org.semanticweb.owlapi.model.EntityType;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static java.util.Objects.requireNonNullElse;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Apr 2017
 */


@JsonTypeName("PerformEntitySearch")
public record PerformEntitySearchAction(@JsonProperty(value = "projectId", required = true) @Nonnull ProjectId projectId,
                                        @JsonProperty(value = "searchString", required = true) @Nonnull String searchString,
                                        @JsonProperty(value = "entityTypes", defaultValue = "[]") @Nonnull Set<EntityType<?>> entityTypes,
                                        @JsonProperty("langTagFilter") @Nonnull LangTagFilter langTagFilter,
                                        @JsonProperty("searchFilters") @Nonnull ImmutableList<EntitySearchFilter> searchFilters,
                                        @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest) implements ProjectAction<PerformEntitySearchResult>, HasProjectId {

    public static final String CHANNEL = "webprotege.search.PerformEntitySearch";

    public PerformEntitySearchAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                     @JsonProperty("searchString") @Nonnull String searchString,
                                     @JsonProperty(value = "entityTypes") @Nonnull Set<EntityType<?>> entityTypes,
                                     @JsonProperty("langTagFilter") @Nonnull LangTagFilter langTagFilter,
                                     @JsonProperty("searchFilters") @Nonnull ImmutableList<EntitySearchFilter> searchFilters,
                                     @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest) {
        this.projectId = requireNonNull(projectId);
        this.searchString = requireNonNull(searchString);
        this.entityTypes = requireNonNullElse(entityTypes, Collections.emptySet());
        this.langTagFilter = requireNonNullElse(langTagFilter, LangTagFilter.get(ImmutableSet.of()));
        this.searchFilters = requireNonNullElse(searchFilters, ImmutableList.of());
        this.pageRequest = requireNonNullElse(pageRequest, PageRequest.requestFirstPage());
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
