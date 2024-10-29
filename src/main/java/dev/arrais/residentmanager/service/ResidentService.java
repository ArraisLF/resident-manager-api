package dev.arrais.residentmanager.service;

import dev.arrais.residentmanager.model.Resident;
import dev.arrais.residentmanager.model.Stay;
import dev.arrais.residentmanager.repository.ResidentRepository;
import dev.arrais.residentmanager.repository.StayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResidentService {

    private final ResidentRepository residentRepository;
    private final StayRepository stayRepository;

    public Resident createResident(Resident resident) {
        return residentRepository.save(resident);
    }

    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    public Optional<Resident> getResidentById(Long id) {
        return residentRepository.findById(id);
    }

    public Stay registerStay(Long residentId, Stay stay) {
        return residentRepository.findById(residentId).map(resident -> {
            stay.setResident(resident);
            return stayRepository.save(stay);
        }).orElseThrow(() -> new RuntimeException("Resident not found"));
    }

    public List<Stay> getStaysByResidentId(Long residentId) {
        return stayRepository.findByResidentId(residentId);
    }
}
