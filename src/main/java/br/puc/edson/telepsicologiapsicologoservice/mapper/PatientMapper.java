package br.puc.edson.telepsicologiapsicologoservice.mapper;

import br.puc.edson.telepsicologiapsicologoservice.dto.PatientDto;
import br.puc.edson.telepsicologiapsicologoservice.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );

    PatientDto modelToDto(Patient patient);
}
