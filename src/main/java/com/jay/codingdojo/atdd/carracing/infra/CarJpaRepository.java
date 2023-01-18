package com.jay.codingdojo.atdd.carracing.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.carracing.domain.Car;

public interface CarJpaRepository extends JpaRepository<Car, Long> {
}