package br.puc.edson.telepsicologiapacienteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenValidationResponseDto {

    private Boolean valid;
}
