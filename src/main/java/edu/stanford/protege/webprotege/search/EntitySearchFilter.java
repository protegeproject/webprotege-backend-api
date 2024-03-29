package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.common.LanguageMap;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.criteria.EntityMatchCriteria;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-15
 */
@AutoValue

public abstract class EntitySearchFilter {

    public static final String ID = "_id";

    public static final String PROJECT_ID = "projectId";

    public static final String LABEL = "label";

    public static final String CRITERIA = "criteria";

    @JsonCreator
    @Nonnull
    public static EntitySearchFilter get(@JsonProperty(ID) @Nonnull EntitySearchFilterId id,
                                         @JsonProperty(PROJECT_ID) @Nonnull ProjectId projectId,
                                         @JsonProperty(LABEL) @Nonnull LanguageMap label,
                                         @JsonProperty(CRITERIA) @Nonnull EntityMatchCriteria entityMatchCriteria) {
        return new AutoValue_EntitySearchFilter(id, projectId, label, entityMatchCriteria);
    }

    @JsonProperty(ID)
    @Nonnull
    public abstract EntitySearchFilterId getId();

    @JsonProperty(PROJECT_ID)
    @Nonnull
    public abstract ProjectId getProjectId();

    @JsonProperty(LABEL)
    @Nonnull
    public abstract LanguageMap getLabel();

    @JsonProperty(CRITERIA)
    @Nonnull
    public abstract EntityMatchCriteria getEntityMatchCriteria();
}
