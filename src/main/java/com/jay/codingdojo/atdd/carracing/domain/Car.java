package com.jay.codingdojo.atdd.carracing.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	private CarRacing carRacing;

	public Car(String name, CarRacing carRacing) {
		if (name.length() > 5 || name.length() < 1) {
			throw new IllegalArgumentException("Car name must be between 1 and 5 characters");
		}
		this.name = name;
		this.carRacing = carRacing;
	}

	public static List<Car> createCars(String names, CarRacing carRacing) {
		List<String> carNames = List.of(names.split(","));
		return carNames.stream()
			.map(name -> new Car(name, carRacing))
			.toList();
	}
}
