package com.sample.loginform.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.loginform.model.Register;

public interface RegisterRepo extends JpaRepository<Register,Long> {

	Optional<Register> findByUsernameAndPassword(String username, String password);

}
