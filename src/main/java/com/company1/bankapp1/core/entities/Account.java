package com.company1.bankapp1.core.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="ACCOUNT")
public class Account {

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private Long ibanId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user_id")
	@Setter(AccessLevel.NONE)
	private User user;


	public void setUser(User user) {
		this.user = user;
		if (!user.getAccounts().contains(this)) { // may cause performance issues -- O(n)
			user.getAccounts().add(this);
		}
	}


}
