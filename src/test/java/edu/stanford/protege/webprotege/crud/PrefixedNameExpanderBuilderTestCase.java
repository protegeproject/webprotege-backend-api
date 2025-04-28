package edu.stanford.protege.webprotege.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.vocab.Namespaces;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 16/04/2014
 */
public class PrefixedNameExpanderBuilderTestCase {

    private PrefixedNameExpander.Builder builder;

    @BeforeEach
    public void setUp() throws Exception {
        builder = PrefixedNameExpander.builder();
    }

    public void shouldThrowNullPointerExceptionForNullPrefixName() {
        assertThrows(NullPointerException.class, () -> {
            builder.withPrefixNamePrefix(null, "x");
        });
    }

    public void shouldThrowNullPointerExceptionForNullPrefix() {
        assertThrows(NullPointerException.class, () -> {
            builder.withPrefixNamePrefix("x:", null);
        });
    }

    public void shouldThrowIllegalArgumentExceptionForNonColonizedPrefixName() {
        assertThrows(NullPointerException.class, () -> {
            builder.withPrefixNamePrefix("x", "y");
        });
    }

    public void shouldThrowIllegalArgumentExceptionForDoubleColonizedPrefixName() {
        assertThrows(NullPointerException.class, () -> {
            builder.withPrefixNamePrefix("x::", "y");
        });
    }

    public void shouldThrowIllegalArgumentExceptionForStartEndDoubleColonizedPrefixName() {
        assertThrows(NullPointerException.class, () -> {
            builder.withPrefixNamePrefix(":x:", "y");
        });
    }

    @Test
    public void shouldAddNamespaces() {
        builder.withNamespaces(Namespaces.values());
    }
}
