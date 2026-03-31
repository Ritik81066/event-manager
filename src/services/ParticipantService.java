package services;

import repository.ParticipantRepository;
import models.Participant;

import java.util.List;

public class ParticipantService {

    private ParticipantRepository participantRepository;

    public ParticipantService() {
        participantRepository = new ParticipantRepository();
    }

    public int createParticipant(Participant participant) {
        return participantRepository.createOrGetParticipant(
                participant.getName(),
                participant.getEmail()
        );
    }

    public boolean registerParticipant(int eventId, Participant participant) {

        // 🔥 Get correct participant ID (existing or new)
        int participantId = participantRepository.createOrGetParticipant(
                participant.getName(),
                participant.getEmail()
        );

        if (participantId == -1) {
            System.out.println("Participant creation failed");
            return false;
        }

        // ✅ Use correct ID (NOT participant.getParticipantId())
        return participantRepository.registerParticipant(eventId, participantId);
    }

    public List<Participant> getParticipants(int eventId) {
        return participantRepository.getParticipantsByEvent(eventId);
    }

    public boolean removeParticipant(int eventId, int participantId) {
        System.out.println("Remove logic can be added later.");
        return true;
    }
}