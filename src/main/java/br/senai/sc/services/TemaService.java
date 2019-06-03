package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Tema;
import br.senai.sc.repositories.TemaRepository;

@Service
public class TemaService {

	@Autowired
	private TemaRepository repo;
	
	public Tema findById(Integer id) {
		Optional<Tema> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Tema> findAll(){
		return repo.findAll();
	}
	
	public void insert(Tema obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Tema obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}

}
