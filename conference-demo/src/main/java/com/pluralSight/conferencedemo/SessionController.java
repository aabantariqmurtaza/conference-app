package com.pluralSight.conferencedemo;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

	@Autowired
	private SessionRepository repository;
	
	@GetMapping
	public List<Session> list(){
		return repository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Session get(@PathVariable Long id) {
		return repository.getOne(id);
	}
	
	@PostMapping
	public Session create(@RequestBody final Session session) {
		return repository.saveAndFlush(session);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		Session existingSession = repository.getOne(id);
		BeanUtils.copyProperties(session, existingSession,"session_id");
		return repository.saveAndFlush(existingSession);
	}
	
	
	
	
	
	
}
