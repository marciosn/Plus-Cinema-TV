package com.es.ufc.quixada.teste;

import java.util.List;

import com.es.ufc.persisntence.SerieJPADAO;
import com.es.ufc.quixada.Serie;

public class TestaListaSerie {

	public static void main(String[] args) {
		SerieJPADAO serieDAO = new SerieJPADAO();
		List<Serie> series = serieDAO.find();
		for(Serie s: series){
			System.out.println("Nome: "+s.getNome());
			System.out.println("Ano: "+s.getAno());
			System.out.println("Genero: "+s.getGenero());
			System.out.println("Nota: "+s.getNotaMedia());
			System.out.println("Nota: "+s.getUrl());
			System.out.println("Nota: "+s.getId());
		}

	}

}
