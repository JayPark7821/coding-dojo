package com.jay.codingdojo.atdd.carracing.domain;

import java.util.List;

public interface CarRepository {
	List<Car> saveAll(List<Car> car);
}
