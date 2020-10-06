package com.company1.bankapp1;

import com.company1.bankapp1.controllers.CommandHandler;
import com.company1.bankapp1.core.entities.Account;
import com.company1.bankapp1.core.entities.User;
import com.company1.bankapp1.core.repositories.AccountRepository;
import com.company1.bankapp1.core.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }


    @Override
    public void run(String... args) throws InterruptedException {
        log.info("\n ----  StartApplication ------- run() ------- START");

        // TODO: make CommandHandler work with UserService
        // TODO: consider making CommandHandler a bean
        CommandHandler.handleCommand(args);


        log.info("\n ---- StartApplication ------- run() ------- END");
    }

}
