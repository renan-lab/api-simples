package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
