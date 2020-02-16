package com.example.demo.model;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Integer> {

}
