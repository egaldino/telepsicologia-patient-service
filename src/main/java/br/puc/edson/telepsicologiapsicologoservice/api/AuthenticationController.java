package br.puc.edson.telepsicologiapsicologoservice.api;


import br.puc.edson.telepsicologiapsicologoservice.dto.LoginDto;
import br.puc.edson.telepsicologiapsicologoservice.dto.LoginResponseDto;
import br.puc.edson.telepsicologiapsicologoservice.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AuthenticationController {

    private final PatientService service;


    @PostMapping("/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto form){
        return service.findByEmail(form.getEmail())
                .map(patient -> LoginResponseDto.builder().userId(patient.getCpf()).build())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


}
