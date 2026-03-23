package repository;

import config.DatabaseConnection;
import models.Venue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VenueRepository {

    public List<Venue> getAllVenues() {

        List<Venue> venues = new ArrayList<>();

        String query = "SELECT * FROM venues";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {

                Venue venue = new Venue();

                venue.setVenueId(rs.getInt("venue_id"));
                venue.setVenueName(rs.getString("venue_name"));
                venue.setLocation(rs.getString("location"));

                venues.add(venue);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venues;
    }
}