package com.company1.bankapp1.core.services;

import com.company1.bankapp1.core.entities.Account;
import com.company1.bankapp1.core.entities.User;
import com.company1.bankapp1.core.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// service to maintain operations with users
@Service
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public User createUser(String firstName, String lastName, String username, boolean isAdmin) {
		User newUser = new User(firstName, lastName, username, isAdmin);
		User savedUser = userRepository.save(newUser);
		return savedUser;
	}

	@Transactional
	public User createUserWithAccounts(String firstName, String lastName, String username, boolean isAdmin, List<Account> accounts) {
		User newUser = new User(firstName, lastName, username, isAdmin, accounts);
		User savedUser = userRepository.save(newUser);
		return savedUser;
	}


	@Transactional
	public User createUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}



}
