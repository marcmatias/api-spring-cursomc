package com.marcmatias.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) @ToString
@NoArgsConstructor
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	@EqualsAndHashCode.Include private Integer id;
	@Getter @Setter
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	@Getter @Setter
	private List<Produto> produtos = new ArrayList<>();

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
}
