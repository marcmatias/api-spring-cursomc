package com.marcmatias.cursomc.dto;

import java.io.Serializable;

import com.marcmatias.cursomc.domain.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Integer id;
	@Getter @Setter
	private String nome;
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	
	
}
