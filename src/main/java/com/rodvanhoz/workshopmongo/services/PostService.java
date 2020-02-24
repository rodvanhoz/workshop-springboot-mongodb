package com.rodvanhoz.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodvanhoz.workshopmongo.domain.Post;
import com.rodvanhoz.workshopmongo.repository.PostRepository;
import com.rodvanhoz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		
		try {
			
			Post user = repo.findById(id).get();
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
