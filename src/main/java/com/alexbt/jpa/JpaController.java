package com.alexbt.jpa;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class JpaController {

	@Autowired
	private ModelJpaRepository modelJpaRepository;
	
	@RequestMapping(path="/repo", method = RequestMethod.GET)
	public Iterable<Company> findByRepo() throws IOException {
		return modelJpaRepository.findAll();
	}
	
	@RequestMapping(value = "/repo/{value}", method = RequestMethod.GET)
	public void saveByRepo(@PathVariable String value) {
		Company model = new Company();
		model.setId(System.currentTimeMillis());
		model.setName(value);
		modelJpaRepository.save(model);
	}
}
