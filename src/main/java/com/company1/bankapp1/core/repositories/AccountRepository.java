package com.company1.bankapp1.core.repositories;

import com.company1.bankapp1.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<User, Long> {

}
