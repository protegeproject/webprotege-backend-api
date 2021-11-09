package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.color.Color;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
@JsonTypeName("webprotege.tags.AddProjectTag")
public record AddProjectTagAction(ProjectId projectId,
                                  String label,
                                  String description,
                                  Color color,
                                  Color backgroundColor) implements ProjectAction<AddProjectTagResult> {

    public static final String CHANNEL = "webprotege.tags.AddProjectTag";

    /**
     * Creates an {@link AddProjectTagAction}.
     *
     * @param projectId       The project id which the tag should be added to.
     * @param label           The label for the tag.  Must not be empty.
     * @param description     The description for the tag.  May be empty.
     * @param color           The color for the tag (foreground).
     * @param backgroundColor The background-color for the tag
     */
    @JsonCreator
    @Nonnull
    public static AddProjectTagAction create(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                             @JsonProperty("label") @Nonnull String label,
                                             @JsonProperty("description") @Nonnull String description,
                                             @JsonProperty("color") @Nonnull Color color,
                                             @JsonProperty("backgroundColor") @Nonnull Color backgroundColor) {
        return new AddProjectTagAction(projectId, label, description, color, backgroundColor);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }


    public AddProjectTagAction(ProjectId projectId,
                               String label,
                               String description,
                               Color color,
                               Color backgroundColor) {
        this.projectId = checkNotNull(projectId);
        this.label = checkNotNull(label);
        this.description = checkNotNull(description);
        this.color = checkNotNull(color);
        this.backgroundColor = checkNotNull(backgroundColor);
    }
}
