package com.jay.codingdojo.atdd.okr.infrastructure.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.okr.domain.user.User;

public interface userRepository extends JpaRepository<User,Long> {
}
