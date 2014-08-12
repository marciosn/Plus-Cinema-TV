package com.es.ufc.persisntence;

import com.es.ufc.quixada.Filme;

public class FilmeJPADAO extends GenericJPADAO<Filme> implements FilmeDAO{
	public FilmeJPADAO(){
		this.persistentClass = Filme.class;
	}
}
