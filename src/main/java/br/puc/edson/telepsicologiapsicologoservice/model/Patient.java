package br.puc.edson.telepsicologiapsicologoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
public class Patient {

    @Id
    private String cpf;
    private String email;
    private String name;

}
