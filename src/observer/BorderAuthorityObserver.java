package observer;

import model.TravelStatus;

public class BorderAuthorityObserver implements Observer{
    @Override
    public void update(TravelStatus status) {
        System.out.println("Border Authority notified: Status is now " + status);
    }
}
