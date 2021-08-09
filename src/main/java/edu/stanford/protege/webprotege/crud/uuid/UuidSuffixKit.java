package edu.stanford.protege.webprotege.crud.uuid;

import edu.stanford.protege.webprotege.crud.EntityCrudKit;
import edu.stanford.protege.webprotege.crud.EntityCrudKitId;
import edu.stanford.protege.webprotege.crud.EntityCrudKitPrefixSettings;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
import org.semanticweb.owlapi.model.IRI;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 13/08/2013
 */
public class UuidSuffixKit extends EntityCrudKit<UuidSuffixSettings> {

    public static final String EXAMPLE_SUFFIX = "RtvBaCCEyk09YwGRQljc2z";

    private static final EntityCrudKitId ID = EntityCrudKitId.get("UUID");

    @Inject
    public UuidSuffixKit() {
        super(ID, "Auto-generated Universally Unique Id (UUID)");
    }

    public static EntityCrudKitId getId() {
        return ID;
    }

    @Override
    public EntityCrudKitPrefixSettings getDefaultPrefixSettings() {
        return EntityCrudKitPrefixSettings.get();
    }

    @Override
    public UuidSuffixSettings getDefaultSuffixSettings() {
        return UuidSuffixSettings.get();
    }

    @Override
    public Optional<String> getPrefixValidationMessage(String prefix) {
        if(!(prefix.endsWith("#") || prefix.endsWith("/"))) {
            return Optional.of("It is recommended that your prefix ends with a forward slash i.e. <b>/</b> (or a #)");
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public IRI generateExample(EntityCrudKitPrefixSettings prefixSettings, UuidSuffixSettings suffixSettings) {
        return IRI.create(prefixSettings.getIRIPrefix(), EXAMPLE_SUFFIX);
    }

    @Override
    public GeneratedAnnotationsSettings getDefaultGeneratedAnnotationsSettings() {
        return GeneratedAnnotationsSettings.empty();
    }
}
