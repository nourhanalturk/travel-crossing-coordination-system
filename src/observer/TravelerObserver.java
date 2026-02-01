package observer;

import model.TravelStatus;

public class TravelerObserver implements Observer{
    @Override
    public void update(TravelStatus status) {
        System.out.println("Traveler notified: Travel status changed to " + status);
    }
}
