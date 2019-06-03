package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Cliente;
import br.senai.sc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public void insert(Cliente obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Cliente obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}

}
