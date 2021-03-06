package edu.stanford.protege.webprotege.crud.oboid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.crud.EntityCrudKitId;
import edu.stanford.protege.webprotege.crud.EntityCrudKitSuffixSettings;

import javax.annotation.Nonnull;

import static edu.stanford.protege.webprotege.crud.oboid.OboIdSuffixSettings.TYPE_ID;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 13/08/2013
 * <p>
 *     Settings for generating OBO style Ids.
 * </p>
 */
@AutoValue

@JsonTypeName(TYPE_ID)
public abstract class OboIdSuffixSettings extends EntityCrudKitSuffixSettings {

    public static final String TYPE_ID = "OboId";

    public static final int DEFAULT_TOTAL_DIGITS = 7;

    public static final String TOTAL_DIGITS = "totalDigits";

    public static final String USER_ID_RANGES = "userIdRanges";

    public static OboIdSuffixSettings get() {
        return get(DEFAULT_TOTAL_DIGITS, ImmutableList.of());
    }

    @JsonCreator
    public static OboIdSuffixSettings get(@JsonProperty(TOTAL_DIGITS) int totalDigits, @JsonProperty(USER_ID_RANGES) @Nonnull ImmutableList<UserIdRange> userIdRanges) {
        return new AutoValue_OboIdSuffixSettings(totalDigits, userIdRanges);
    }

    @JsonIgnore
    public EntityCrudKitId getKitId() {
        return OboIdSuffixKit.getId();
    }

    @JsonProperty(TOTAL_DIGITS)
    public abstract int getTotalDigits();

    @JsonProperty(USER_ID_RANGES)
    public abstract ImmutableList<UserIdRange> getUserIdRanges();
}
