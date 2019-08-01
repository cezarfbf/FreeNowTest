package com.freenow.api.repository;

import com.freenow.api.model.Driver;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long> {
	
	Optional<Driver> findByName(String name);
}
