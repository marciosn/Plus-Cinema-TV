package com.es.ufc.quixada;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.PeriodicEventListener;

import antlr.collections.List;

import com.es.ufc.persisntence.FilmeJPADAO;
import com.es.ufc.quixada.controll.PersistenceClass;
import com.es.ufc.repositorio.Repositorio;
import com.google.gson.Gson;

/**
 * Servlet implementation class Server
 * 
 * 
 * https://marciosn1@bitbucket.org/marciosn1/pluscinema-tv-server.git
 * 
 * 
 */
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Repositorio repositorio = new Repositorio();
	private PersistenceClass persistence = new PersistenceClass();
	private int quantidade_de_eventos = 0;
	private int n = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// response.getOutputStream().println("YEEEESSS!! THIS SERVLET WORKS.....");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HashMap<String, Object> hm = new HashMap<String, Object>();
		Gson gson = new Gson();

		if (request.getParameter("var") != null) {
			String param = request.getParameter("var");
			System.out.println("Param = " + param);
			if (param.equals("ListaDeSeries")) {
				System.out.println("Enviar Series");
				String lista = new Gson().toJson(persistence.getSerieBanco());
				hm.put("message", lista);
			} else if (param.equals("ListaDeFilmes")) {
				System.out.println("Enviar Filmes");
				String lista = new Gson().toJson(persistence.getFilmeBanco());
				hm.put("message", lista);
			} else if (param.equals("TamanhoDaLista")) {
				String tamlis = new Gson().toJson(persistence.getFilmeBanco()
						.size());
				hm.put("message", tamlis);
			} else if (nota(param)) {
				if (existeFilme(verificaNome(param))) {
					calculaNotaFilme(verificaNome(param), verificaNota(param));
				} else if (existeSerie(verificaNome(param))) {
					calculaNotaSerie(verificaNome(param), verificaNota(param));
				}
			} else if (isFilme(param)) {
				votarQueroAssistirFilme(param);
				System.out.println("Quero Assitir Filme Adicionado + 1");
			} else if (isSerie(param)) {
				votarQueroAssistirSerie(param);
				System.out.println("Quero Assitir Serie Adicionado + 1");
			}
		}
		try {
			String msg = gson.toJson(hm);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
		} catch (Exception enviarobjeto) {
			enviarobjeto.printStackTrace();
		}
	}

	public Filme converteParaObjeto(String s) {
		Gson gson = new Gson();
		Filme filme = gson.fromJson(s, Filme.class);
		return filme;
	}

	public String converteParaString(Filme filme) {
		Gson gson = new Gson();
		String filmeJSONString = gson.toJson(filme);
		return filmeJSONString;
	}

	public String verificaNome(String n) {
		int contador = n.length();
		for (int i = 0; i < contador; i++) {
			if (n.subSequence(i, i + 1).equals(" ")) {
				String nomeFilme = n.substring(n.indexOf(" "));

				return nomeFilme.trim();
			}
		}
		return "NaoEncontrado";
	}

	public String verificaNota(String n) {
		int contador = n.length();
		for (int i = 0; i < contador; i++) {
			if (n.subSequence(i, i + 1).equals(" ")) {
				String notaFilme = n.substring(0, n.indexOf(" "));
				return notaFilme;
			}
		}
		return "NaoEncontrado";
	}

	public boolean nota(String n) {
		if (n.contains(".0 ")) {
			return true;
		} else
			return false;
	}

	public boolean existeFilme(String n) {
		java.util.List<Filme> filmes = new ArrayList<Filme>();
		filmes = persistence.getFilmeBanco();
		for (int i = 0; i < filmes.size(); i++) {
			if (filmes.get(i).getNome().contains(n)) {
				System.out.println("Quantidade de votos "
						+ filmes.get(i).getQuantidadeDeVotos());
				return true;
			}
		}
		return false;
	}

	public boolean existeSerie(String n) {
		java.util.List<Serie> series = new ArrayList<Serie>();
		series = persistence.getSerieBanco();
		for (int i = 0; i < series.size(); i++) {
			if (series.get(i).getNome().contains(n)) {
				System.out.println("Quantidade de votos "
						+ series.get(i).getQuantidadeDeVotos());
				return true;
			}
		}
		return false;
	}

	public float converte(String s) {
		Float nota = Float.valueOf(s);
		return nota;
	}

	public void calculaNotaFilme(String nome, String nota) {
		java.util.List<Filme> filmes = new ArrayList<Filme>();
		filmes = persistence.getFilmeBanco();
		String resul = null;
		for (int i = 0; i < filmes.size(); i++) {
			if (filmes.get(i).getNome().contains(nome)) {
				filmes.get(i).setQuantidadeDeVotos(
						filmes.get(i).getQuantidadeDeVotos() + 1);
				int quantidadeVotos = filmes.get(i).getQuantidadeDeVotos();
				float NotaMediaBanco = converte(filmes.get(i).getNotaMedia());
				float NovaNota = converte(nota);
				float resultado = (NotaMediaBanco + NovaNota) / 2;
				resul = String.valueOf(resultado);
				System.out.println(NotaMediaBanco + " + " + NovaNota + " / "
						+ quantidadeVotos + " = " + resul);
				filmes.get(i).setNotaMedia(resul);
				persistence.update(filmes.get(i));
				System.out.println("Nota Media Resultado " + resul);
			}
		}
	}

	public void calculaNotaSerie(String nome, String nota) {
		java.util.List<Serie> series = new ArrayList<Serie>();
		series = persistence.getSerieBanco();
		String resul = null;
		for (int i = 0; i < series.size(); i++) {
			if (series.get(i).getNome().contains(nome)) {
				System.out.println("passou pelo if");
				series.get(i).setQuantidadeDeVotos(
						series.get(i).getQuantidadeDeVotos() + 1);
				int quantidadeVotos = series.get(i).getQuantidadeDeVotos();
				float NotaMediaBanco = converte(series.get(i).getNotaMedia());
				float NovaNota = converte(nota);
				float resultado = (NotaMediaBanco + NovaNota) / 2;
				resul = String.valueOf(resultado);
				System.out.println(NotaMediaBanco + " + " + NovaNota + " / "
						+ quantidadeVotos + " = " + resul);
				series.get(i).setNotaMedia(resul);
				persistence.updateSerie(series.get(i));
				System.out.println("Nota Media Resultado " + resul);
			}
		}
	}

	public boolean isFilme(String nome) {
		java.util.List<Filme> filmes = new ArrayList<Filme>();
		filmes = persistence.getFilmeBanco();
		for (int i = 0; i < filmes.size(); i++) {
			if (filmes.get(i).getNome().contains(nome)) {
				return true;
			}
		}
		return false;
	}

	public void votarQueroAssistirFilme(String nome) {
		java.util.List<Filme> filmes = new ArrayList<Filme>();
		filmes = persistence.getFilmeBanco();
		for (int i = 0; i < filmes.size(); i++) {
			if (filmes.get(i).getNome().contains(nome)) {
				filmes.get(i).setQueroAssistir(
						filmes.get(i).getQueroAssistir() + 1);
				persistence.update(filmes.get(i));
			}
		}
	}

	public boolean isSerie(String nome) {
		java.util.List<Serie> series = new ArrayList<Serie>();
		series = persistence.getSerieBanco();
		for (int i = 0; i < series.size(); i++) {
			if (series.get(i).getNome().contains(nome)) {
				return true;
			}
		}
		return false;
	}

	public void votarQueroAssistirSerie(String nome) {
		java.util.List<Serie> series = new ArrayList<Serie>();
		series = persistence.getSerieBanco();
		for (int i = 0; i < series.size(); i++) {
			if (series.get(i).getNome().contains(nome)) {
				series.get(i).setQueroAssistir(
						series.get(i).getQueroAssistir() + 1);
				persistence.updateSerie(series.get(i));
			}
		}
	}
}
