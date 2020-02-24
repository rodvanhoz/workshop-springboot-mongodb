package com.rodvanhoz.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodvanhoz.workshopmongo.domain.User;
import com.rodvanhoz.workshopmongo.repository.UserRepository;
import com.rodvanhoz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
	
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		try {
			
			User user = repo.findById(id).get();
			if (user == null) {
				
				throw new ObjectNotFoundException("Objeto nao encontrado");
			}
			
			return user;
		}
		catch (Exception e) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		
	}
}
