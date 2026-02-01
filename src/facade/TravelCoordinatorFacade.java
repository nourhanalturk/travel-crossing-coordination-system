package facade;

import model.TravelRequest;
import model.TravelStatus;
import model.Traveler;
import model.UserRole;
import observer.BorderAuthorityObserver;
import observer.TravelOfficeObserver;
import observer.TravelerObserver;
import singleton.TravelSystemDatabase;
import strategy.PaymentStrategy;

public class TravelCoordinatorFacade {
    private TravelSystemDatabase database;
    public TravelCoordinatorFacade(){
        this.database = TravelSystemDatabase.getInstance();
    }
    public String submitTravelRequest(Traveler traveler , PaymentStrategy paymentStrategy,double amount){

        String requestId = "REQ-" + System.currentTimeMillis();

        TravelRequest request = new TravelRequest(requestId,traveler);
        request.addObserver(new TravelerObserver());
        request.addObserver(new TravelOfficeObserver());
        request.addObserver(new BorderAuthorityObserver());

        paymentStrategy.pay(amount);
        database.addRequest(request);

        request.setStatus(TravelStatus.SUBMITTED);
        System.out.println("Travel request submitted successfully.\n");
        return  requestId;
    }
    public void updateTravelStatus(String requestId , TravelStatus newStatus , UserRole role){
        TravelRequest request = database.getRequestById(requestId);
        if (!isStatusChangeAllowed(role, newStatus)) {
            System.out.println("Access denied: Role not allowed to set this status.");
            return;
        }

        request.setStatus(newStatus);
        System.out.println("Status updated to " + newStatus + " by " + role);


    }
    private boolean isStatusChangeAllowed(UserRole role,
                                          TravelStatus status) {

        return switch (role) {
            case TRAVELER -> status == TravelStatus.SUBMITTED;
            case TRAVEL_OFFICE -> status == TravelStatus.APPROVED
                    || status == TravelStatus.DELAYED;
            case BORDER_AUTHORITY -> status == TravelStatus.SCHEDULED
                    || status == TravelStatus.REJECTED;
            default -> false;
        };
    }

}
