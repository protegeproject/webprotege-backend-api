package edu.stanford.protege.webprotege.event;



import edu.stanford.protege.webprotege.HasUserId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.user.UserId;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 27/03/2013
 */
public class UserStartingViewingProjectEvent extends ProjectEvent implements HasUserId {

    private UserId userId;

    public UserStartingViewingProjectEvent(ProjectId source, UserId userId) {
        super(source);
        this.userId = userId;
    }

    private UserStartingViewingProjectEvent() {

    }

    @Override
    public UserId getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserStartingViewingProjectEvent");
        sb.append("(");
        sb.append(userId);
        sb.append(" ");
        sb.append(getSource());
        sb.append(")");
        return sb.toString();
    }
}
