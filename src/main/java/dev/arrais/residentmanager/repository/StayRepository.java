package dev.arrais.residentmanager.repository;

import dev.arrais.residentmanager.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Long> {
    List<Stay> findByResidentId(Long residentId);
}
