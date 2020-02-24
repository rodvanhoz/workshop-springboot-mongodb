package com.rodvanhoz.workshopmongo.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String text) {
		
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSerach(text, minDate, maxDate);
	}
}
