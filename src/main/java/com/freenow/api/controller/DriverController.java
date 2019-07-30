package com.freenow.api.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.freenow.api.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freenow.api.model.Driver;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired
	private DriverRepository drivers;
	
	@GetMapping
	public List<Driver> drivers() {

		return drivers.findAll();
		
	}
	

}
