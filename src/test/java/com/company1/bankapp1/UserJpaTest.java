package com.company1.bankapp1;

import com.company1.bankapp1.core.entities.Account;
import com.company1.bankapp1.core.entities.User;
import com.company1.bankapp1.core.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
//        classes = UserJpaTestConfiguration.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserJpaTest {

  private static final Logger log = LoggerFactory.getLogger(UserJpaTest.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TransactionTemplate transactionTemplate;



  @Test
  public void shouldSaveAndLoadUser() {
    log.info("\n======= shouldSaveAndLoadUser -- START");

    long orderId =  transactionTemplate.execute((ts) -> {

      User user4 = new User("user4_first_name", "user4_last_name", "user4", false, "CURRENT_ADMIN'S_USERNAME");
      Account acc1 = new Account();
      Account acc2 = new Account();
      Account acc3 = new Account();
      user4.addAccount(acc1).addAccount(acc2).addAccount(acc3);
      log.info("=== before saving: user1.getId() = " + user4.getId());

      userRepository.save(user4);
      log.info("=== after saving: user1.getId() = " + user4.getId());
      ts.flush();
      return user4.getId();
    });

    transactionTemplate.execute((ts) -> {
      User user = userRepository.findById(orderId).get();

      assertNotNull(user);
      assertEquals("user4_first_name", user.getFirstName());
      assertEquals("user4_last_name", user.getLastName());
      assertEquals("CURRENT_ADMIN'S_USERNAME", user.getCreator());
      assertFalse(user.isAdmin());
      log.info("\n======= shouldSaveAndLoadUser -- END");
      return null;
    });

  }


  @Before // just to be sure
  @After
  public void cleanup() {
    log.info("\n ==== cleanup -- START ==== \n");
    userRepository.deleteAll();
    log.info("\n ==== cleanup -- END ==== \n");
  }

}///
