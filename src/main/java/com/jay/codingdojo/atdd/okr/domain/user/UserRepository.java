package com.jay.codingdojo.atdd.okr.domain.user;

import java.util.Optional;

public interface UserRepository {

	Optional<User> findByEmail(String email);
}
