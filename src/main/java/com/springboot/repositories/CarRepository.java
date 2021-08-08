package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
