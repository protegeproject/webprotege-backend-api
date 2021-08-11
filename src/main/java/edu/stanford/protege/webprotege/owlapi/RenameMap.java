package edu.stanford.protege.webprotege.owlapi;

import org.semanticweb.owlapi.model.IRI;

import javax.annotation.Nonnull;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 22/02/2013
 * <p>
 *     An object that records renamings of IRIs.
 * </p>
 */
public record RenameMap(Map<IRI, IRI> map) {

    /**
     * Constructs a {@link RenameMap} from the specified IRI map.
     * @param map The map from which to construct this rename map.  Not {@code null}.
     * @throws NullPointerException if {@code map} is {@code null}.
     */
    public RenameMap(@Nonnull Map<IRI, IRI> map) {
        this.map = Map.copyOf(checkNotNull(map));
    }
}
