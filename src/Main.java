import facade.TravelCoordinatorFacade;
import model.TravelStatus;
import model.Traveler;
import model.UserRole;
import strategy.BankOfPalestinePayment;
import strategy.PaymentStrategy;

public class Main {
    public static void main(String[] args) {
        Traveler traveler = new Traveler("1", "Nourhan");

        PaymentStrategy payment = new BankOfPalestinePayment();

        TravelCoordinatorFacade facade = new TravelCoordinatorFacade();

        String requestId =facade.submitTravelRequest(traveler, payment, 150.0);
        facade.updateTravelStatus(requestId, TravelStatus.APPROVED, UserRole.TRAVELER);
    }
}