package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Festa;
import br.senai.sc.repositories.FestaRepository;

@Service
public class FestaService {

	@Autowired
	private FestaRepository repo;
	
	public Festa findById(Integer id) {
		Optional<Festa> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Festa> findAll(){
		return repo.findAll();
	}
	
	public void insert(Festa obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Festa obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}

}
