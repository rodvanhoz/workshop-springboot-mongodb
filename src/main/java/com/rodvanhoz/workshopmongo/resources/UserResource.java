package com.rodvanhoz.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodvanhoz.workshopmongo.domain.User;
import com.rodvanhoz.workshopmongo.dto.UserDto;
import com.rodvanhoz.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	// @GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		
		List<User> list = service.findAll();
		List<UserDto> listDto = list.stream()
				.map(x -> new UserDto(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
