package repository;

import config.DatabaseConnection;
import models.Participant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantRepository {

    // 🔥 Create OR Get Existing Participant
    public int createOrGetParticipant(String name, String email) {

        int participantId = -1;

        try (Connection conn = DatabaseConnection.getConnection()) {

            // ✅ Step 1: Check if already exists
            String checkQuery = "SELECT participant_id FROM participants WHERE email = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, email);

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("participant_id"); // already exists
            }

            // ✅ Step 2: Insert new participant
            String insertQuery = "INSERT INTO participants(name, email) VALUES (?, ?) RETURNING participant_id";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, name);
            insertStmt.setString(2, email);

            ResultSet insertRs = insertStmt.executeQuery();

            if (insertRs.next()) {
                participantId = insertRs.getInt("participant_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return participantId;
    }

    // 🔥 Register Participant to Event
    public boolean registerParticipant(int eventId, int participantId) {

        String query = """
                INSERT INTO registrations (event_id, participant_id)
                VALUES (?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, eventId);
            stmt.setInt(2, participantId);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 🔥 Get Participants of Event
    public List<Participant> getParticipantsByEvent(int eventId) {

        List<Participant> participants = new ArrayList<>();

        String query = """
                 SELECT p.participant_id, p.name, p.email
                                        FROM participants p
                                        JOIN registrations r
                                        ON p.participant_id = r.participant_id
                                        WHERE r.event_id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, eventId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Participant p = new Participant();

                p.setParticipantId(rs.getInt("participant_id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));

                participants.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participants;
    }
}