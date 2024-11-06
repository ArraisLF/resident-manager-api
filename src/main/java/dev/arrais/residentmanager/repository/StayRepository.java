package dev.arrais.residentmanager.repository;

import dev.arrais.residentmanager.model.Stay;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StayRepository extends JpaRepository<Stay, Long> {
  List<Stay> findByResidentId(Long residentId);
}
