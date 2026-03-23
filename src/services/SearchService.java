package services;

import algorithms.BinarySearch;
import models.Event;

import java.util.List;

public class SearchService {

    public Event searchEventById(List<Event> events, int eventId) {

        return BinarySearch.searchById(events, eventId);
    }
}