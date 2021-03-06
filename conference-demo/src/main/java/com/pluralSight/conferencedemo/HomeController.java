package com.pluralSight.conferencedemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
//	jdbc:postgresql://localhost:5432/conference_app
//	postgres
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping
	@RequestMapping("/")
	public Map<String, String> getVersion(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("App_Version", appVersion);
		return map;
	}

}
