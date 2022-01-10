package de.evoila.rest;

import de.evoila.rest.models.Employee;
import de.evoila.rest.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Peter", "Developer")));
            log.info("Preloading " + repository.save(new Employee("Arthur", "Engineer")));
            log.info("Preloading " + repository.save(new Employee("Anna", "Professor")));
        };
    }

}
