package br.puc.edson.telepsicologiapsicologoservice.api;


import br.puc.edson.telepsicologiapsicologoservice.dto.PatientDto;
import br.puc.edson.telepsicologiapsicologoservice.mapper.PatientMapper;
import br.puc.edson.telepsicologiapsicologoservice.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {

    private final PatientService service;

    @GetMapping("/")
    List<PatientDto> listAll() {
        return service.listAll()
                .stream()
                .map(PatientMapper.INSTANCE::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PatientDto> findByCrp(@PathVariable String cpf) {
        return service.findByCpf(cpf)
                .map(PatientMapper.INSTANCE::modelToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
