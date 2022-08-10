package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.model.Patient;
import br.puc.edson.telepsicologiapsicologoservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    private final DataCryptoService dataCryptoService;

    public List<Patient> listAll() {
        return repository.findAll()
                .stream()
                .map(this::decrypt)
                .collect(Collectors.toList());
    }

    public Optional<Patient> findByCpf(String cpf) {
        return repository.findByCpfHash(DigestUtils.sha256Hex(cpf)).map(this::decrypt);
    }

    private Patient decrypt(Patient patient) {
        return Patient
                .builder()
                .cpfHash(patient.getCpfHash())
                .cpf(dataCryptoService.decrypt(patient.getCpf()))
                .email(dataCryptoService.decrypt(patient.getEmail()))
                .name(dataCryptoService.decrypt(patient.getName()))
                .build();
    }
}
