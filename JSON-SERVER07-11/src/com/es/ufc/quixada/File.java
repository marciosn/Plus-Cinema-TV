package com.es.ufc.quixada;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "File")
@NamedQuery (name = "File.findFile", query = "from File")
public class File implements Serializable{
	private static final long serialVersionUID = 4644676059414738542L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String notaMedia;
	private String ano;
	private String genero;
	
	/*public File(String nome, String nota, String ano, String genero){
		this.nome = nome;
		this.notaMedia = nota;
		this.ano = ano;
		this.genero = genero;
	}*/
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
}
