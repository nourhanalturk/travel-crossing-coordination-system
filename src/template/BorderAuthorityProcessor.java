package template;

import model.TravelRequest;
import model.TravelStatus;
import model.UserRole;

public class BorderAuthorityProcessor extends  TravelRequestProcessor{
    @Override
    protected boolean isStatusChangeAllowed(UserRole role) {
        return role == UserRole.BORDER_AUTHORITY;
    }

    @Override
    protected void validate(TravelRequest request) {
        System.out.println("Border Authority validating documents...");
    }

    @Override
    protected void updateStatus(TravelRequest request) {
        request.setStatus(TravelStatus.SCHEDULED);
    }
}
