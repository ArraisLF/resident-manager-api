package dev.arrais.residentmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "residents")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resident {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        @NotBlank(message = "Name is mandatory")
        private String name;

        @Column(name = "last_name", nullable = false)
        @NotBlank(message = "Last name is mandatory")
        private String lastName;

        @Column(name = "cpf", nullable = false, unique = true)
        @NotBlank(message = "CPF is mandatory")
        @Pattern(regexp = "\\d{11}", message = "CPF must be 11 digits")
        private String cpf;

        @Column(name = "birth_date", nullable = false)
        @NotNull(message = "Birth date is mandatory")
        private LocalDate birthDate;

        @Column(name = "contact_info")
        @Size(max = 255, message = "Contact info must be less than 255 characters")
        private String contactInfo;

        @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Stay> stays;
}
