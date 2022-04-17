package com.example.tp8;

import com.example.tp8.Entities.Etudiant;
import com.example.tp8.Repositories.EtudiantRepository;
import com.example.tp8.security.Services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Tp8Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp8Application.class, args);
    }

    @Bean // au demarrage crée un objet de type PasswordEncoder
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){
        return args -> {
            etudiantRepository.save(
                    new Etudiant(null, "elkamouni","soukaina","soukaina@gmail.com",new Date(),"F",true)
            );
            etudiantRepository.save(
                    new Etudiant(null, "khadidi","salma","salma@gmail.com",new Date(),"F",true)
            );
            etudiantRepository.findAll().forEach(p ->{
                System.out.println(p.getNom());
            });
        };
    }

    @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("Mohamed", "1234", "1234");
            securityService.saveNewUser("Yassamine", "1234", "1234");
            securityService.saveNewUser("Hassan", "1234", "1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("Mohamed","USER");
            securityService.addRoleToUser("Mohamed","ADMIN");
            securityService.addRoleToUser("Yassamine","USER");
            securityService.addRoleToUser("Hassan","USER");

        };
    }
}


