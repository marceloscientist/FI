package br.senai.sc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.domain.Tema;
import br.senai.sc.services.TemaService;

@RestController
@RequestMapping(value = "/temas")
public class TemaResource {

	@Autowired
	private TemaService serv;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tema>> ListarTodos(){
		List<Tema> lista = serv.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tema> buscarPorId(@PathVariable Integer id){
		Tema obj = serv.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Tema obj){
		serv.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Tema obj, @PathVariable Integer id){
		obj.setId(id);
		serv.update(obj);
		return ResponseEntity.noContent().build();
	}

}
