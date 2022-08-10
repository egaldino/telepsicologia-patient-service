package br.puc.edson.telepsicologiapacienteservice.mapper;

import br.puc.edson.telepsicologiapacienteservice.dto.PatientDto;
import br.puc.edson.telepsicologiapacienteservice.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );

    PatientDto modelToDto(Patient patient);
}
