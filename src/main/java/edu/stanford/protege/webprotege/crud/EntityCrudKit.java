package edu.stanford.protege.webprotege.crud;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.stanford.protege.webprotege.crud.gen.GeneratedAnnotationsSettings;
import edu.stanford.protege.webprotege.crud.oboid.OboIdSuffixKit;
import edu.stanford.protege.webprotege.crud.supplied.SuppliedNameSuffixKit;
import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixKit;
import org.semanticweb.owlapi.model.IRI;

import java.io.Serializable;
import java.util.Optional;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 08/08/2013
 * <p>
 *     An {@code EntityCrudKit} is used by the system when creating and updating entities.  Each kit provides a human
 *     readable name, an editor for viewing and altering settings for the kit and a back end implementation that actually
 *     generates the ontology changes required to enact high level changes such as "creating" a fresh term, or updating
 *     the display name.
 * </p>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(OboIdSuffixKit.class),
        @JsonSubTypes.Type(UuidSuffixKit.class),
        @JsonSubTypes.Type(SuppliedNameSuffixKit.class)
})
public abstract class EntityCrudKit<S extends EntityCrudKitSuffixSettings> implements Serializable {

    private EntityCrudKitId kitId;

    private String displayName;

    /**
     * For serialization purposes only!
     */
    protected EntityCrudKit() {
    }

    /**
     * Creates a descriptor for the specified information.
     * @param kitId The id of the kit. Not {@code null}.
     * @param displayName The display name for the kit.  Not {@code null}.
     * @throws NullPointerException if any parameters are {@code null}.
     */
    public EntityCrudKit(EntityCrudKitId kitId, String displayName) {
        this.kitId = checkNotNull(kitId);
        this.displayName = checkNotNull(displayName);
    }

    /**
     * Gets the id for this kit.
     * @return The id.  Not {@code null}.
     */
    @JsonIgnore
    public EntityCrudKitId getKitId() {
        return kitId;
    }

    /**
     * Gets the human readable display name for this kit.
     * @return The name.  Not {@code null}.
     */
    public String getDisplayName() {
        return displayName;
    }

    public abstract EntityCrudKitPrefixSettings getDefaultPrefixSettings();

    public abstract S getDefaultSuffixSettings();

    public abstract Optional<String> getPrefixValidationMessage(String prefix);

    public abstract IRI generateExample(EntityCrudKitPrefixSettings prefixSettings, S suffixSettings);


    @Override
    public String toString() {
        return toStringHelper("EntityCrudKit")
                .addValue(kitId)
                .add("displayName", displayName)
                .toString();
    }

    public abstract GeneratedAnnotationsSettings getDefaultGeneratedAnnotationsSettings();
}
