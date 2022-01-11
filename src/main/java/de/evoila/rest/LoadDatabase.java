package de.evoila.rest;

import de.evoila.rest.models.Employee;
import de.evoila.rest.models.Order;
import de.evoila.rest.repositories.EmployeeRepository;
import de.evoila.rest.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Developer", "Peter", "Parker")));
            log.info("Preloading " + repository.save(new Employee("Engineer", "Mary", "Jane")));
            log.info("Preloading " + repository.save(new Employee("Professor", "Tom", "Holland")));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }

}
