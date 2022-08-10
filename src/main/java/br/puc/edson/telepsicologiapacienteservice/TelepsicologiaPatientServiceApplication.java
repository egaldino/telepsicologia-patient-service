package br.puc.edson.telepsicologiapacienteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TelepsicologiaPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelepsicologiaPatientServiceApplication.class, args);
	}

}
