package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.model.Patient;
import br.puc.edson.telepsicologiapsicologoservice.repository.PatientRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository repository;

    @InjectMocks
    private PatientService service;

    @Test
    public void shouldListAllPsychologists(){
        EasyRandom generator = new EasyRandom();
        List<Patient> databaseReturn = generator.objects(Patient.class, 5)
                .collect(Collectors.toList());
        when(repository.findAll()).thenReturn(databaseReturn);

        List<Patient> result = service.listAll();

        assertEquals(databaseReturn.size(), result.size());
        for(int i=0; i < result.size(); i++){
            assertEquals(databaseReturn.get(i).getCpf(),result.get(i).getCpf());
            assertEquals(databaseReturn.get(i).getName(),result.get(i).getName());
        }

    }

}