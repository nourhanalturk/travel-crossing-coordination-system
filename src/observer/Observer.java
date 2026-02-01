package observer;

import model.TravelStatus;

public interface Observer {
    void update(TravelStatus status);
}
