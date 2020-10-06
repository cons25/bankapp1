package com.company1.bankapp1.core.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="\"USER\"")
public class User {

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String username;


	@NotNull
	private boolean isAdmin;

	// username of admin who created this User
	private String creator;


	@OneToMany(
					mappedBy = "user",
					cascade = CascadeType.ALL,
					orphanRemoval = true
	)
	private List<Account> accounts;



	public User(String firstName, String lastName, String username, boolean isAdmin){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.isAdmin = isAdmin;
		this.accounts = new ArrayList<>();
	}

	public User(String firstName, String lastName, String username, boolean isAdmin, String creator){
		this(firstName, lastName, username, isAdmin);
		this.creator = creator;
	}

	public User(String firstName, String lastName, String username, boolean isAdmin, List<Account> accounts){
		this(firstName, lastName, username, isAdmin);
		this.accounts = accounts;
	}

	public User(String firstName, String lastName, String username, boolean isAdmin, String creator, List<Account> accounts){
		this(firstName, lastName, username, isAdmin, creator);
		this.accounts = accounts;
	}



	public User addAccount(Account account) {
		this.accounts.add(account);
		if (account.getUser() != this) {
			account.setUser(this);
		}
		return this;
	}


}
