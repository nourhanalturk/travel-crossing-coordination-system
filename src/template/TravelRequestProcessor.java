package template;

import model.TravelRequest;
import model.UserRole;

public abstract class TravelRequestProcessor {
    public final void process(TravelRequest request, UserRole role) {
        if (!isStatusChangeAllowed(role)) {
            throw new RuntimeException("Access denied");
        }
        validate(request);
        updateStatus(request);
    }

    protected abstract boolean isStatusChangeAllowed(UserRole role);


    protected abstract void validate(TravelRequest request);
    protected abstract void updateStatus(TravelRequest request);

}
