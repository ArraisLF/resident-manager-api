package dev.arrais.residentmanager.controller;

import dev.arrais.residentmanager.model.Resident;
import dev.arrais.residentmanager.model.Stay;
import dev.arrais.residentmanager.service.ResidentService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {
  private final ResidentService residentService;

  ResidentController(ResidentService residentService) {
    this.residentService = residentService;
  }

  // Create a new resident
  @PostMapping
  public ResponseEntity<Resident> createResident(@Valid @RequestBody Resident resident) {
    Resident createdResident = residentService.createResident(resident);
    return ResponseEntity.ok(createdResident);
  }

  // Get all residents
  @GetMapping
  public ResponseEntity<List<Resident>> getAllResidents() {
    List<Resident> residents = residentService.getAllResidents();
    return ResponseEntity.ok(residents);
  }

  // Get a resident by ID
  @GetMapping("/{id}")
  public ResponseEntity<Resident> getResidentById(@PathVariable Long id) {
    return residentService
        .getResidentById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Register a new stay for a resident
  @PostMapping("/{residentId}/stays")
  public ResponseEntity<Stay> registerStay(
      @PathVariable Long residentId, @Valid @RequestBody Stay stay) {
    try {
      Stay registeredStay = residentService.registerStay(residentId, stay);
      return ResponseEntity.ok(registeredStay);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  // Get all stays for a resident
  @GetMapping("/{residentId}/stays")
  public ResponseEntity<List<Stay>> getStaysByResidentId(@PathVariable Long residentId) {
    Optional<Resident> resident = residentService.getResidentById(residentId);
    if (resident.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    List<Stay> stays = residentService.getStaysByResidentId(residentId);
    return ResponseEntity.ok(stays);
  }
}
