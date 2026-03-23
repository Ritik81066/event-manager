package services;

import models.Event;

import java.util.*;

public class RecommendationService {

    public List<Event> recommendByCategory(
            List<Event> events,
            String categoryName
    ) {

        List<Event> recommended = new ArrayList<>();

        for (Event e : events) {

            if (e.getCategoryName() == categoryName) {
                recommended.add(e);
            }
        }

        recommended.sort(Comparator.comparing(Event::getEventDate));

        return recommended;
    }
}