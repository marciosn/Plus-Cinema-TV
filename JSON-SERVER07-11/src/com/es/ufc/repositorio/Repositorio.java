package com.es.ufc.repositorio;

import java.util.ArrayList;

import com.es.ufc.quixada.Evento;
import com.es.ufc.quixada.File;

public class Repositorio {
	private ArrayList<Evento> eventos = new ArrayList<>();
	private ArrayList<File> files = new ArrayList<>();

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public ArrayList<File> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}

}
