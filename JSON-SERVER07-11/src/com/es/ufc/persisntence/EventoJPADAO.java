package com.es.ufc.persisntence;

import com.es.ufc.quixada.Evento;

public class EventoJPADAO extends GenericJPADAO<Evento> implements EventoDAO{
	
	public EventoJPADAO(){
		this.persistentClass = Evento.class;
	}

}
