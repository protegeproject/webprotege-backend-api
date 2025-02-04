package edu.stanford.protege.webprotege.crud.icatx;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.crud.EntityCrudKitId;
import edu.stanford.protege.webprotege.crud.EntityCrudKitSuffixSettings;
import edu.stanford.protege.webprotege.crud.oboid.OboIdSuffixSettings;

import static edu.stanford.protege.webprotege.crud.icatx.IcatxSuffixSettings.TYPE_ID;


@AutoValue

@JsonTypeName(TYPE_ID)
public class IcatxSuffixSettings  extends EntityCrudKitSuffixSettings {

    public static final String TYPE_ID = "IcatXId";
    public static IcatxSuffixSettings get() {
        return new IcatxSuffixSettings();
    }


    @Override
    public EntityCrudKitId getKitId() {
        return IcatxGenerationSuffixKit.getId();
    }
}
