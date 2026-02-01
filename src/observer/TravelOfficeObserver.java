package observer;

import model.TravelStatus;

public class TravelOfficeObserver implements Observer{
    @Override
    public void update(TravelStatus status) {
        System.out.println("Travel Office notified: Status updated to " + status);
    }
}
