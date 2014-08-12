package com.es.ufc.quixada.controll;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.es.ufc.persisntence.FilmeJPADAO;
import com.es.ufc.persisntence.SerieJPADAO;
import com.es.ufc.quixada.Filme;
import com.es.ufc.quixada.Serie;
@SessionScoped
@ManagedBean
public class PersistenceClass {
	private SerieJPADAO serieDAO = new SerieJPADAO();
	private FilmeJPADAO filmeDAO = new FilmeJPADAO();
	private Filme filme =  new Filme();
	private Serie serie = new Serie();
	List<Serie> series = serieDAO.find();
	List<Filme> filmes = filmeDAO.find();
	
	public List<Serie> getSerieBanco(){
		List<Serie> series = serieDAO.find();
		return series;
	}
	public List<Filme> getFilmeBanco(){
		List<Filme> filmes = filmeDAO.find();
		return filmes;
	}
	public void update(Filme filme){
		try {
			filmeDAO.beginTransaction();
			filmeDAO.save(filme);
			filmeDAO.commit();
		} catch (Exception e) {
			filmeDAO.rollback();
			e.printStackTrace();
		} finally{
			//filmeDAO.close();
		}
	}
	public void updateSerie(Serie serie){
		try {
			serieDAO.beginTransaction();
			serieDAO.save(serie);
			serieDAO.commit();
		} catch (Exception e) {
			serieDAO.rollback();
			e.printStackTrace();
		} finally{
			//filmeDAO.close();
		}
	}
	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

}
