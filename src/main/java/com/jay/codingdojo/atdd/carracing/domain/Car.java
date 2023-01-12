package com.jay.codingdojo.atdd.carracing.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	private Long id;
	private String name;

	public Car(String name) {
		this.name = name;
	}
}
