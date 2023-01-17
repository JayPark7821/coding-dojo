package com.jay.codingdojo.atdd.carracing.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

public interface CarJpaRepository extends CarRepository, JpaRepository<Car, Long> {
}
