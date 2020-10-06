package com.company1.bankapp1;

import com.company1.bankapp1.core.entities.Account;
import com.company1.bankapp1.core.entities.User;
import com.company1.bankapp1.core.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


//TODO: configure test context not ot fail from "UserService bean autowiring error"
//TODO: UserService temporarily commented out in main app

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryDataJpaTest {

	private static final Logger log = LoggerFactory.getLogger(UserJpaTest.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repository;

// TODO: add also UserServiceTests
// TODO: add also CommandHandler tests

// TODO: add tests/asserts for child collection (Accounts)

// TODO: add deletion / update tests


	@Test
	public void testCreateUserWithAccountsAndThenFindIt() {

		log.info("\n************* testCreateUserWithAccountsAndThenFindIt -- START");


		User user3 = new User("user3_first_name", "user3_last_name", "user3", false, "CURRENT_ADMIN'S_USERNAME");
		Account acc1 = new Account();
		Account acc2 = new Account();
		user3.addAccount(acc1).addAccount(acc2);

		entityManager.persist(user3);
		entityManager.flush();


		List<User> users = repository.findByLastName("user3_last_name");
		assertEquals(1, users.size());

		assertThat(users).extracting(User::getFirstName).containsOnly("user3_first_name");

		log.info("\n************* testCreateUserWithAccountsAndThenFindIt -- END");
	}


}
