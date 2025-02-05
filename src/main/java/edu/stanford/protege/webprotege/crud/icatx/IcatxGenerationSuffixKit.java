package edu.stanford.protege.webprotege.crud.icatx;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.crud.EntityCrudKit;
import edu.stanford.protege.webprotege.crud.EntityCrudKitId;
import edu.stanford.protege.webprotege.crud.EntityCrudKitPrefixSettings;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
import org.semanticweb.owlapi.model.IRI;

import java.util.Optional;

@JsonTypeName("IcatX")
public class IcatxGenerationSuffixKit extends EntityCrudKit<IcatxSuffixSettings> {

    public static final String DEFAULT_PREFIX = "http://who.int/whofic/";

    private static final EntityCrudKitId ID = EntityCrudKitId.get("IcatX");

    public IcatxGenerationSuffixKit() {
        super(ID, "Icatx suffix kit");
    }

    @JsonIgnore
    public static EntityCrudKitId getId() {
        return ID;
    }


    @Override
    public EntityCrudKitPrefixSettings getDefaultPrefixSettings() {
        return EntityCrudKitPrefixSettings.get(DEFAULT_PREFIX, ImmutableList.of());
    }

    @Override
    public IcatxSuffixSettings getDefaultSuffixSettings() {
        return IcatxSuffixSettings.get();
    }

    @Override
    public Optional<String> getPrefixValidationMessage(String prefix) {
        if(prefix.endsWith(DEFAULT_PREFIX)) {
            return Optional.of("The default prefix is specified.  You should change this to suit your ontology.");
        }
        return Optional.empty();
    }

    @Override
    public IRI generateExample(EntityCrudKitPrefixSettings prefixSettings, IcatxSuffixSettings suffixSettings) {
        return IRI.create(prefixSettings.getIRIPrefix(), "1897656051");
    }

    @Override
    public GeneratedAnnotationsSettings getDefaultGeneratedAnnotationsSettings() {
        return GeneratedAnnotationsSettings.empty();
    }
}
