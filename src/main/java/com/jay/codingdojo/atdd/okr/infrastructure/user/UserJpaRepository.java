package com.jay.codingdojo.atdd.okr.infrastructure.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.domain.user.UserRepository;

public interface UserJpaRepository extends JpaRepository<User, Long>, UserRepository {

	Optional<User> findByEmail(String email);
}
