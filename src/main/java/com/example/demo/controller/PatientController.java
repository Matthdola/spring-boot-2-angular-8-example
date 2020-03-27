package com.example.demo.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientRepository;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {
	private PatientRepository repository;
	
	
	@Autowired
	public PatientController(PatientRepository repo) {
		this.repository = repo;
	}
	
	@GetMapping
	@CrossOrigin(origins="http://localhost:4200")
	public Collection<Patient> getPatients() {
		return repository.findAll().stream()
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public void addPatient(@Valid @NotNull @RequestBody Patient p) {
		this.repository.save(p);
	}
	
	
	@PutMapping(path = "{id}")
	public void updatePatient(@PathVariable("id") int id, @Valid @NotNull @RequestBody Patient p) {
		this.repository.save(p);
	}
	
	@GetMapping(path = "{id}")
	public Patient getPatient(@PathVariable("id") int id) {
		return this.repository.getOne(id);
	}
	
	@DeleteMapping(path = "{id}")
	public Patient deletePatient(@PathVariable("id") int id) {
		Patient p = repository.getOne(id);
		if (p != null ) {
			repository.deleteById(id);
		}
		return null;
	}
	
	@PutMapping(path = "{id}{lat}{lon}")
	public void changePatientLocation(@PathVariable("id") int id, @PathVariable("lat") double lat, @PathVariable("lon") double lon) {
		Patient p = repository.getOne(id);
		if (p != null) {
			p.setLatitude(lat);
			p.setLongitude(lon);
			this.repository.save(p);
		}
	}
}
