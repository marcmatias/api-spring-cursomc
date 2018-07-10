package com.marcmatias.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marcmatias.cursomc.domain.Categoria;
import com.marcmatias.cursomc.repositories.CategoriaRepository;
import com.marcmatias.cursomc.services.exceptions.DataIntegrityException;
import com.marcmatias.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
				+ ", Tipo: " + Categoria.class.getName()));
		
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
	    catch(DataIntegrityViolationException e){
	    	throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
	    }
	}
	
}
