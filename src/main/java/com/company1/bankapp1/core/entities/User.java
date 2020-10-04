package com.company1.bankapp1.core.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name="\"USER\"")
public class User {

	@Id @GeneratedValue
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



	public User(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}





}
