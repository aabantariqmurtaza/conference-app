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
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

	@Autowired
	private SpeakerRepository repository;
	
	@GetMapping
	public List<Speaker> list(){
		return repository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(@PathVariable Long id) {
		return repository.getOne(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker existingSpeaker = repository.getOne(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
		return repository.saveAndFlush(existingSpeaker);
	}

	@PostMapping
	public Speaker create(@RequestBody final Speaker speaker) {
		return repository.saveAndFlush(speaker);
	}
	
	
	
}
