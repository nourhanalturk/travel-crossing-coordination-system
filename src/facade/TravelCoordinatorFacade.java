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
import template.BorderAuthorityProcessor;
import template.TravelRequestProcessor;

public class TravelCoordinatorFacade {
    private TravelSystemDatabase database;

    public TravelCoordinatorFacade() {
        this.database = TravelSystemDatabase.getInstance();
    }

    public String submitTravelRequest(Traveler traveler, PaymentStrategy paymentStrategy, double amount) {

        String requestId = "REQ-" + System.currentTimeMillis();

        TravelRequest request = new TravelRequest(requestId, traveler);
        request.addObserver(new TravelerObserver());
        request.addObserver(new TravelOfficeObserver());
        request.addObserver(new BorderAuthorityObserver());

        paymentStrategy.pay(amount);
        database.addRequest(request);

        request.setStatus(TravelStatus.SUBMITTED);
        System.out.println("Travel request submitted successfully.\n");
        return requestId;
    }

    public void processByBorderAuthority(String requestId, UserRole role) {

        TravelRequest request = database.getRequestById(requestId);

        if (request == null) {
            System.out.println("Request not found.");
            return;
        }

        TravelRequestProcessor processor =
                new BorderAuthorityProcessor();

        processor.process(request, role);
    }

}
