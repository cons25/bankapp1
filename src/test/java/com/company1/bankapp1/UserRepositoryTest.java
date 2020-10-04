package com.company1.bankapp1;

import com.company1.bankapp1.core.entities.Account;
import com.company1.bankapp1.core.entities.User;
import com.company1.bankapp1.core.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repository;

// TODO: add also UserServiceTest

// TODO: add tests/asserts for child collection (Accounts)

// TODO: add deletion / update tests


	@Test
	public void testCreateUserWithAccountsAndThenFindIt() {

		User user3 = new User("user3_first_name", "user3_last_name", "user3", false, "CURRENT_ADMIN'S_USERNAME");
		Account acc1 = new Account();
		Account acc2 = new Account();
		user3.addAccount(acc1);
		user3.addAccount(acc2);

		entityManager.persist(user3);


		List<User> users = repository.findByLastName("user3_last_name");
		assertEquals(1, users.size());

		assertThat(users).extracting(User::getFirstName).containsOnly("user3_first_name");

	}


}
