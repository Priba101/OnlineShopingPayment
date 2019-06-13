package com.techprimers.db;


import com.techprimers.db.model.Kartice;
import com.techprimers.db.model.Korpa;
import com.techprimers.db.model.Kupovina;
import com.techprimers.db.repository.KarticeRepository;
import com.techprimers.db.repository.KorpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.techprimers.db.repository")
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    @Autowired
    private KorpaRepository korpaRepository;
    private KarticeRepository karticeRepository;

    public static void main(String args[]){
        SpringApplication.run(JpaApplication.class,args);
    }
    @Override
    public void run(String... args){
        //korpaRepository.save(new Korpa(2,2,1,5,new Kupovina(2,5,2,"2/2/2018")));
        //karticeRepository.save(new Kartice(1,"visa",122,123,"12/2020","test","test",200,1,new Korpa(2,2,1,5)));
    }
}