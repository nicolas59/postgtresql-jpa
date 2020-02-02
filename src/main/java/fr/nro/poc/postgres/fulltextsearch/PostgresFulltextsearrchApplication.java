package fr.nro.poc.postgres.fulltextsearch;

import fr.nro.poc.postgres.fulltextsearch.domain.Address;
import fr.nro.poc.postgres.fulltextsearch.domain.Person;
import fr.nro.poc.postgres.fulltextsearch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
public class PostgresFulltextsearrchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresFulltextsearrchApplication.class, args);
	}

}
