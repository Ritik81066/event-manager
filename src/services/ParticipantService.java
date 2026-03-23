package services;

import repository.ParticipantRepository;
import models.Participant;

import java.util.List;

public class ParticipantService {

    private ParticipantRepository participantRepository;

    public ParticipantService() {
        participantRepository = new ParticipantRepository();
    }

    public boolean createParticipant(Participant participant) {

        return participantRepository.createParticipant(participant);
    }

    public boolean registerParticipant(int eventId, Participant participant) {

        boolean created = participantRepository.createParticipant(participant);

        if (!created) return false;

        return participantRepository.registerParticipant(
                eventId,
                participant.getParticipantId()
        );
    }

    public List<Participant> getParticipants(int eventId) {

        return participantRepository.getParticipantsByEvent(eventId);
    }

    public boolean removeParticipant(int eventId, int participantId) {

        // simplified logic
        System.out.println("Remove logic can be added later.");
        return true;
    }
}