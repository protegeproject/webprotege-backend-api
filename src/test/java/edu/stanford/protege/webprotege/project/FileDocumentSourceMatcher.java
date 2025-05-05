package edu.stanford.protege.webprotege.project;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.semanticweb.owlapi.io.FileDocumentSource;
import org.semanticweb.owlapi.io.OWLOntologyDocumentSource;
import org.semanticweb.owlapi.model.IRI;

import java.io.File;

/**
 * @author Matthew Horridge,
 * Stanford University,
 * Bio-Medical Informatics Research Group
 * Date: 19/02/2014
 */
public class FileDocumentSourceMatcher<T extends OWLOntologyDocumentSource> extends TypeSafeMatcher<T> {


    private final File ontologyDocumentSource;

    public FileDocumentSourceMatcher(File ontologyDocumentSource) {
        this.ontologyDocumentSource = ontologyDocumentSource;
    }

    public static FileDocumentSourceMatcher isFileDocumentSourceForFile(File file) {
        return new FileDocumentSourceMatcher(file);
    }

    @Override
    protected boolean matchesSafely(T source) {
        IRI expectedIRI = IRI.create(ontologyDocumentSource);
        return source instanceof FileDocumentSource && source.getDocumentIRI().equals(expectedIRI);
    }

    @Override
    public void describeTo(Description description) {
    }
}
