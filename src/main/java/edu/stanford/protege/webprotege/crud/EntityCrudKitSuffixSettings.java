package edu.stanford.protege.webprotege.crud;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.stanford.protege.webprotege.crud.icatx.IcatxSuffixSettings;
import edu.stanford.protege.webprotege.crud.oboid.OboIdSuffixSettings;
import edu.stanford.protege.webprotege.crud.supplied.SuppliedNameSuffixSettings;
import edu.stanford.protege.webprotege.crud.uuid.UuidSuffixSettings;

import java.io.Serializable;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 08/08/2013
 * <p>
 *     The settings for an {@link edu.stanford.protege.webprotege.crud.EntityCrudKitHandler}. All subclasses of this class
 *     provide an IRI prefix for term creation.  Settings specific to each concrete subclass are used to generate an
 *     IRI suffix for an term.  This suffix may or may not depend upon a supplied short form for the term.
 * </p>
 */
@JsonSubTypes({
        @Type(value = UuidSuffixSettings.class),
        @Type(value = SuppliedNameSuffixSettings.class),
        @Type(value = IcatxSuffixSettings.class),
        @Type(value = OboIdSuffixSettings.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public abstract class EntityCrudKitSuffixSettings implements Serializable {

        @JsonIgnore
        public abstract EntityCrudKitId getKitId();
}
