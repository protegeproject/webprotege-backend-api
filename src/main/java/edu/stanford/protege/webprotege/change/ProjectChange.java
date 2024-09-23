package edu.stanford.protege.webprotege.change;

import com.fasterxml.jackson.annotation.*;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.diff.DiffElement;
import edu.stanford.protege.webprotege.revision.RevisionNumber;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
@AutoValue
public abstract class ProjectChange implements  Serializable {

    @JsonCreator
    @Nonnull
    public static ProjectChange get(@JsonProperty("revisionNumber") @Nonnull RevisionNumber revisionNumber,
                                    @JsonProperty("userId") UserId author,
                                    @JsonProperty("timestamp") long timestamp,
                                    @JsonProperty("summary") String summary,
                                    @JsonProperty("changeCount") int changeCount,
                                    @JsonProperty("diff") Page<DiffElement<String, String>> diff) {
        return new AutoValue_ProjectChange(changeCount,
                revisionNumber,
                author,
                summary,
                timestamp,
                diff);
    }

    public abstract int getChangeCount();

    public abstract RevisionNumber getRevisionNumber();

    @JsonProperty("userId")
    public abstract UserId getAuthor();
    
    public abstract String getSummary();

    public abstract long getTimestamp();

    public abstract Page<DiffElement<String, String>> getDiff();
}
