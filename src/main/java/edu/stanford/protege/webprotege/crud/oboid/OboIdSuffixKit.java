package edu.stanford.protege.webprotege.crud.oboid;

import com.google.common.collect.ImmutableList;
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
 * Date: 14/08/2013
 */
public class OboIdSuffixKit extends EntityCrudKit<OboIdSuffixSettings> {

    public static final String DEFAULT_PREFIX = "http://purl.obolibrary.org/obo/ONT_";

    private static final EntityCrudKitId ID = EntityCrudKitId.get("OBO");

    @Inject
    public OboIdSuffixKit() {
        super(ID, "Auto-generated  OBO Style Id");
    }

    public static EntityCrudKitId getId() {
        return ID;
    }

    @Override
    public EntityCrudKitPrefixSettings getDefaultPrefixSettings() {
        return EntityCrudKitPrefixSettings.get(DEFAULT_PREFIX, ImmutableList.of());
    }

    @Override
    public OboIdSuffixSettings getDefaultSuffixSettings() {
        return OboIdSuffixSettings.get();
    }

    @Override
    public Optional<String> getPrefixValidationMessage(String prefix) {
        if(prefix.endsWith(DEFAULT_PREFIX)) {
            return Optional.of("The default prefix is specified.  You should change this to suit your ontology.");
        }
        else if(!prefix.endsWith("_")) {
            return Optional.of("OBO IRI prefixes should end with an underscore");
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public IRI generateExample(EntityCrudKitPrefixSettings prefixSettings, OboIdSuffixSettings suffixSettings) {
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(Math.max(0, suffixSettings.getTotalDigits() - 1)));
        sb.append("1");
        return IRI.create(prefixSettings.getIRIPrefix(), sb.toString());
    }

    @Override
    public GeneratedAnnotationsSettings getDefaultGeneratedAnnotationsSettings() {
        return GeneratedAnnotationsSettings.empty();
    }
}
