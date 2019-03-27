package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.management.Query;

import java.sql.Driver;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import antlr.collections.List;
import ch.qos.logback.classic.Logger;
import repo.UserRepository;

@SpringBootApplication
public class Application {

    	private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

    	public static void main(String[] args) {
    		SpringApplication.run(Application.class);
    	}

    	@Bean
    	public CommandLineRunner demo(UserRepository repository) {
    		return (args) -> {
    			// save a couple of customers
    			repository.save(new Mapiranje(0, "visa", 4242, 123, "12/20",null,null,0));
    			repository.save(new Mapiranje(1, "Kim", 1231, 111, "10/20", null, null, 0));
    			repository.save(new Mapiranje(2, "Kim", 3213, 222, "11/20", null, null, 0));
    			repository.save(new Mapiranje(3, "Kim", 3213, 333, "07/21", null, null, 0));

    			// fetch all customers
    			log.info("Customers found with findAll():");
    			log.info("-------------------------------");
    			for (Mapiranje customer : repository.findAll()) {
    				log.info(customer.toString());
    			}
    			log.info("");

    			// fetch an individual customer by ID
    			repository.findById(0)
    				.ifPresent(customer -> {
    					log.info("Customer found with findById(0):");
    					log.info("--------------------------------");
    					log.info(customer.toString());
    					log.info("");
    				});

    			// fetch customers by last name
    			log.info("Customer found with findByTip('visa'):");
    			log.info("--------------------------------------------");
    			repository.findByTip("visa").forEach(visa -> {
    				log.info(bauer.toString());
    			});
    			// for (Customer bauer : repository.findByLastName("Bauer")) {
    			// 	log.info(bauer.toString());
    			// }
    			log.info("");
    		};
    
    }
}
