package com.es.ufc.quixada.teste;

import com.es.ufc.persisntence.FilmeJPADAO;
import com.es.ufc.quixada.Filme;

public class TestaInsereFile {
	private static FilmeJPADAO filmeDAO = new FilmeJPADAO();
	public static void main(String[] args) {
		Filme filme = new Filme();
		Filme filme2 = new Filme();
		   filme.setAno("2012");
		   filme.setGenero("teste");
		   filme.setNome("Homem de aco");
		   filme.setNotaMedia("10");
		   filme.setId(1);
		   filme.setUrl("www.google.com");
		   
		   filme2.setAno("2012");
		   filme2.setGenero("romance");
		   filme2.setNome("Testando");
		   filme2.setNotaMedia("10");
		   filme2.setId(2);
		   filme2.setUrl("www.google.com");
		   
		   try {
				filmeDAO.beginTransaction();
				filmeDAO.save(filme);
				filmeDAO.commit();
			} catch (Exception e) {
				filmeDAO.rollback();
				e.printStackTrace();
			} finally{
				filmeDAO.close();
			}
		
	}
}
