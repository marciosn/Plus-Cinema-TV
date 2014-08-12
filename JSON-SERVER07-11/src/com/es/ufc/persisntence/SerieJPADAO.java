package com.es.ufc.persisntence;

import com.es.ufc.quixada.Serie;

public class SerieJPADAO extends GenericJPADAO<Serie> implements SerieDAO{
	public SerieJPADAO(){
		this.persistentClass = Serie.class;
	}
}
