package com.freenow.api.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.expression.spel.ast.OpOr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freenow.api.model.Driver;

@RestController
@RequestMapping("/drivers")
public class DriverController {
	
	@GetMapping
	public List<Driver> drivers() {
		
		Driver driver = new Driver();
		driver.setId(1L);
		driver.setName("Gutierre Lomovic");
		driver.setDriveLicense("0128310237");
		driver.setRating(89);
		driver.setMemberSince(LocalDate.of(2017, 5, 15));
		
		return Arrays.asList(driver);
		
	}
	

}
