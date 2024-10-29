package dev.arrais.residentmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.arrais.residentmanager.model.Resident;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResidentDTO {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String cpf;

    public static ResidentDTO fromEntity(Resident entity) {
        return ResidentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .birthDate(entity.getBirthDate())
                .cpf(entity.getCpf())
                .build();
    }

    public Resident toEntity() {
        return Resident.builder()
                .id(this.getId())
                .name(this.getName())
                .lastName(this.getLastName())
                .birthDate(this.getBirthDate())
                .cpf(this.getCpf())
                .build();
    }
}
