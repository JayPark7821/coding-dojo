package com.jay.codingdojo.atdd.carracing.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarRacing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "carRacing")
	private List<Car> cars = new ArrayList<>();

	public CarRacing(Long id) {
		this.id = id;
	}

	public void addCar(Car car) {
		cars.add(car);
	}
}
