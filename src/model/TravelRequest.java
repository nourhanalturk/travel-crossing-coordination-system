package model;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class TravelRequest {
    private  Traveler traveler;
    private TravelStatus status;
    private List<Observer> observers = new ArrayList<>();
    private String requestId;


    public TravelRequest(String requestId,Traveler traveler){
        this.requestId = requestId;
        this.traveler = traveler;
        this.status = TravelStatus.SUBMITTED ;
    }

    public String getRequestId() {
        return requestId;
    }

    public Traveler getTraveler() {
        return traveler;
    }
    public void setStatus(TravelStatus newStatus) {
        this.status = newStatus;
        notifyObservers();
    }
    public TravelStatus getStatus() {
        return status;
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
