package com.jay.codingdojo.atdd.carracing.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.carracing.domain.CarRacing;
import com.jay.codingdojo.atdd.carracing.domain.CarRacingRepository;

public interface CarRacingJpaRepository extends CarRacingRepository, JpaRepository<CarRacing, Long> {
}
