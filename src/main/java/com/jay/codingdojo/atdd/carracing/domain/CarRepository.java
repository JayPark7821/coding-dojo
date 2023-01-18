package com.jay.codingdojo.atdd.carracing.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jay.codingdojo.atdd.carracing.infra.CarJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarRepository {

	private final CarJpaRepository repository;

	public List<Car> saveAll(List<Car> cars) {
		return repository.saveAll(cars);
	}
}