package br.puc.edson.telepsicologiapacienteservice.repository;

import br.puc.edson.telepsicologiapacienteservice.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    Optional<Patient> findByCpfHash(String cpfHash);
}
