package com.company1.bankapp1.core.repositories;

import com.company1.bankapp1.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String firstName);

}
