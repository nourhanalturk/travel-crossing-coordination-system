package singleton;

import model.TravelRequest;

import java.util.*;

public class TravelSystemDatabase {
    private static TravelSystemDatabase instance;

    private List<TravelRequest> travelRequests = new ArrayList<>();

    // private constructor
    private TravelSystemDatabase() {
        travelRequests = new ArrayList<>();
    }

    public TravelRequest getRequestById(String requestId) {
        for (TravelRequest request : travelRequests) {
            if (request.getRequestId().equals(requestId)) {
                return request;
            }
        }
        return null;
    }


    public static TravelSystemDatabase getInstance() {
        if (instance == null) {
            instance = new TravelSystemDatabase();
        }
        return instance;
    }
    public void addRequest(TravelRequest request) {
        travelRequests.add(request);
    }

    public List<TravelRequest> getAllRequests() {
        return travelRequests;
    }



}
