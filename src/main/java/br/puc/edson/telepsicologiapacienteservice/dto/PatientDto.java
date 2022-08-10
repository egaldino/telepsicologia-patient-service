package br.puc.edson.telepsicologiapacienteservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PatientDto {

    private String cpf;
    private String name;
}
