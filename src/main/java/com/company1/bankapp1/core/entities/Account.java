package com.company1.bankapp1.core.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="ACCOUNT")
public class Account {

	@Id @GeneratedValue
	@Setter(AccessLevel.NONE)
	private String IBAN;

	public Account() {

	}

}
