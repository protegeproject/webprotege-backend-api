package edu.stanford.protege.webprotege.form.field;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-11-07
 */
public enum FieldRun {

    START,

    CONTINUE;

    public boolean isStart() {
        return this == START;
    }
}
