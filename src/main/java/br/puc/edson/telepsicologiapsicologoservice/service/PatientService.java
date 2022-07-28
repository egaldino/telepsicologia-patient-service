package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.model.Patient;
import br.puc.edson.telepsicologiapsicologoservice.repository.PsychologistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PsychologistRepository repository;

    public List<Patient> listAll() {
        return repository.findAll();
    }

    public Optional<Patient> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<Patient> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
