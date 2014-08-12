package com.es.ufc.quixada.teste;

import java.util.List;

import com.es.ufc.persisntence.FilmeJPADAO;
import com.es.ufc.quixada.File;
import com.es.ufc.quixada.Filme;

public class TesteListaFilme {
	public static void main(String[] args) {
		FilmeJPADAO filmeDAO = new FilmeJPADAO();
		List<Filme> filmes = filmeDAO.find();
		for(Filme f: filmes){
			System.out.println("Nome: "+f.getNome());
			System.out.println("Ano: "+f.getAno());
			System.out.println("Genero: "+f.getGenero());
			System.out.println("Nota: "+f.getNotaMedia());
			System.out.println("Nota: "+f.getUrl());
			System.out.println("Nota: "+f.getId());
		}

	}

}
