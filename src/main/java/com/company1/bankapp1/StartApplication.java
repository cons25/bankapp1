package com.company1.bankapp1;

import com.company1.bankapp1.core.entities.Account;
import com.company1.bankapp1.core.entities.User;
import com.company1.bankapp1.core.repositories.AccountRepository;
import com.company1.bankapp1.core.repositories.UserRepository;
import com.company1.bankapp1.core.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {

        log.info("StartApplication...");

        userService.createUser("user1_first_name", "user2_last_name", "admin1", true);
        userService.createUser("user2_first_name", "user2_last_name", "user2", false);

        User user3 = new User("user3_first_name", "user3_last_name", "user3", false);
        Account acc1 = new Account();
        Account acc2 = new Account();
        user3.addAccount(acc1);
        user3.addAccount(acc2);

        userService.createUser(user3);


    }

}
