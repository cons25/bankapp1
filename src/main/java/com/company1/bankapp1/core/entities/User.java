package com.company1.bankapp1.core.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

	public User(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}





}
