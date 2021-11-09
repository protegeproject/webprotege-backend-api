package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Feb 2018
 *
 * A small class that supports the mapping of a prefix name to a prefix.  This class does not
 * perform any proper checking of prefix names or prefixes.  The only requirement is that
 * prefix names must be terminated with a colon.
 *
 * Constructs a prefix declaration from the specified prefix name and the specified prefix.
 * @param prefixName The prefix name. Any string terminated by a colon is accepted here.
 *                   If the prefix name does not end with a colon then an {@link IllegalArgumentException} will be thrown.
 * @param prefix     The prefix.  Any string is accepted here.  Not checks or guarantees are made
 *                   about the prefix.
 * @return           A prefix declaration that maps the specified prefix name to the specified prefix.
 *
 */
@JsonPropertyOrder({"prefixName", "prefix"})
public record PrefixDeclaration(@Nonnull String prefixName,
                                @Nonnull String prefix) {

    public PrefixDeclaration(@Nonnull String prefixName, @Nonnull String prefix) {
        this.prefixName = checkNotNull(prefixName);
        this.prefix = checkNotNull(prefix);
        if(!prefixName.endsWith(":")) {
            throw new IllegalArgumentException("Prefix names must end with a colon");
        }
    }

    /**
     *  Determines if the prefix in this declaration has a common terminating character.  The vast majority
     * of well-known prefixes end with either a slash or a hash (according to prefix.cc).  Here, we also allow
     * an underscore as a common terminating character in order to support the kinds of prefixes used
     * for OBO identifiers.
     * @return true if the prefix associated with this prefix declaration ends with a slash (/), hash (#) or
     * underscore (_), otherwise false.
     */
    @JsonIgnore
    public boolean isPrefixWithCommonTerminatingCharacter() {
        return prefix.endsWith("/") || prefix.endsWith("#") || prefix.endsWith("_");
    }

    public static PrefixDeclaration get(String prefixName,
                                        String prefix) {
        return new PrefixDeclaration(prefixName, prefix);
    }
}
