package edu.stanford.protege.webprotege.diff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class DiffElement_TestCase<D extends Serializable, E extends Serializable> {


    private final DiffOperation diffOperation = DiffOperation.ADD;

    private DiffElement<D, E> diffElement;

    private DiffElement<D, E> otherDiffElement;

    @Mock
    private D sourceDocument;

    @Mock
    private E lineElement;

    @BeforeEach
    public void setUp() throws Exception {
        diffElement = new DiffElement<>(diffOperation, sourceDocument, lineElement);
        otherDiffElement = new DiffElement<>(diffOperation, sourceDocument, lineElement);
    }

    public void shouldThrowNullPointerExceptionIf_DiffOperation_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new DiffElement<>(null, sourceDocument, lineElement);
        });
    }

    public void shouldThrowNullPointerExceptionIf_SourceDocument_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new DiffElement<>(diffOperation, null, lineElement);
        });
    }

    public void shouldThrowNullPointerExceptionIf_LineElement_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new DiffElement<>(diffOperation, sourceDocument, null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(diffElement, is(equalTo(diffElement)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(diffElement, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(diffElement, is(equalTo(otherDiffElement)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(diffElement.hashCode(), is(otherDiffElement.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(diffElement.toString(), startsWith("DiffElement"));
    }

    @Test
    public void shouldReturnSuppliedDiffOperation() {
        assertThat(diffElement.getDiffOperation(), is(diffOperation));
    }

    @Test
    public void shouldReturnSuppliedSourceDocument() {
        assertThat(diffElement.getSourceDocument(), is(sourceDocument));
    }

    @Test
    public void shouldReturnSuppliedLineElement() {
        assertThat(diffElement.getLineElement(), is(lineElement));
    }
}