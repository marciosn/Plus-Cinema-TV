package com.es.ufc.quixada;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "Serie")
@NamedQuery (name = "Serie.findSerie", query = "from Serie")
public class Serie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 137101389893785278L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String notaMedia;
	private String ano;
	private String genero;
	private String url;
	private String trailer;
	private String sinopse;
	private int quantidadeDeVotos;
	private int queroAssistir;

	public Serie(){
		this.quantidadeDeVotos = 0;
		this.queroAssistir = 0;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(String notaMedia) {
		this.notaMedia = notaMedia;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getQuantidadeDeVotos() {
		return quantidadeDeVotos;
	}
	public void setQuantidadeDeVotos(int quantidadeDeVotos) {
		this.quantidadeDeVotos = quantidadeDeVotos;
	}
	public int getQueroAssistir() {
		return queroAssistir;
	}
	public void setQueroAssistir(int queroAssistir) {
		this.queroAssistir = queroAssistir;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
}
