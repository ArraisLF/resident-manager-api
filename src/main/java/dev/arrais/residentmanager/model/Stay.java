package dev.arrais.residentmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stays")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stay {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "resident_id", nullable = false)
  @NotNull(message = "Resident is mandatory")
  private Resident resident;

  @Column(name = "start_date", nullable = false)
  @NotNull(message = "Start date is mandatory")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;
}
