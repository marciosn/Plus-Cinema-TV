package com.es.ufc.quixada;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table (name = "Tabela_Evento")
@NamedQuery (name = "Evento.findEvento", query = "from Evento")
public class Evento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String posicao;
	private String nome;
	private String local;
	private String data;
	
	public Evento(String nome, String local, String data, String posicao){
		this.posicao = posicao;
		this.nome = nome;
		this.local = local;
		this.data = data;
	}
	

	public String getNome() {
		return nome;
	}

	public String getPosicao() {
		return posicao;
	}


	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
