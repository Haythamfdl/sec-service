package org.sid.secservice;

import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.sec.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
            accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
            accountService.addNewRole(new AppRole(null,"BILLS_MANAGER"));
            accountService.addNewUser(new AppUser(null,"user1","1234",new ArrayList<AppRole>()));
            accountService.addNewUser(new AppUser(null,"user2","1234",new ArrayList<AppRole>()));
            accountService.addNewUser(new AppUser(null,"user3","1234",new ArrayList<AppRole>()));
            accountService.addNewUser(new AppUser(null,"user4","1234",new ArrayList<AppRole>()));
            accountService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<AppRole>()));
            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
            accountService.addRoleToUser("user3","USER");
            accountService.addRoleToUser("user3","PRODUCT_MANAGER");
            accountService.addRoleToUser("user4","USER");
            accountService.addRoleToUser("user4","BILLS_MANAGER");
        };
    }
}