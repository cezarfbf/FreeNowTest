package com.freenow.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.freenow.api.model.Driver;
import com.freenow.api.repository.DriverRepository;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired
	private DriverRepository repository;

	@GetMapping
	public List<Driver> drivers() {

		return repository.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Driver> search(@PathVariable Long id) {
		Optional<Driver> driver = repository.findById(id);

		if (driver.isPresent()) {
			return ResponseEntity.ok(driver.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Driver> create(@Valid @RequestBody Driver driver) {
		Optional<Driver> existingDriver = repository.findByName(driver.getName());

		if (existingDriver.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"There is already a driver with the name: " + driver.getName());
		} else {
			repository.save(driver);
			return ResponseEntity.ok(driver);
		}
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<Driver> update(@PathVariable("id") Long id, @Valid @RequestBody Driver driver) {
		Optional<Driver> opt = repository.findById(id);

		if (opt.isPresent()) {

			Driver dvr = opt.get();

			dvr.setName(driver.getName());
			dvr.setDriveLicense(driver.getDriveLicense());
			dvr.setRating(driver.getRating());

			return ResponseEntity.ok(repository.save(dvr));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Driver> delete(@PathVariable("id") Long id) {
		Optional<Driver> opt = repository.findById(id);

		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok(opt.get());
		}
		return ResponseEntity.notFound().build();
	}
}
