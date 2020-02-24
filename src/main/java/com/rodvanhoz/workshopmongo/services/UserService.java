package com.rodvanhoz.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodvanhoz.workshopmongo.domain.User;
import com.rodvanhoz.workshopmongo.dto.UserDto;
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
	
	public User insert(User obj) {
		
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDto objDto) {
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
