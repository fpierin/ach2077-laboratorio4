package br.usp.each.ach2077.laboratorio4.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.each.ach2077.laboratorio4.modelo.Logica;
import br.usp.each.ach2077.laboratorio4.repositorios.PontoGeograficoDAO;
import br.usp.each.ach2077.laboratorio4.representacoes.PontoGeografico;

public class Adicionar implements Logica {

	private PontoGeograficoDAO pontoGeograficoDAO;

	public Adicionar() {
		this.pontoGeograficoDAO = new PontoGeograficoDAO();
	}
	
	@Override
	public void executa(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		System.out.println("Criando novo ponto geografico...");
		
		PontoGeografico pontoGeografico = new PontoGeografico();
		pontoGeografico.setId(Integer.parseInt(request.getParameter("id")));		
		pontoGeografico.setNome(request.getParameter("nome"));
		pontoGeografico.setGraus(Integer.parseInt(request.getParameter("graus")));
		pontoGeografico.setMinutos(Integer.parseInt(request.getParameter("minutos")));
		pontoGeografico.setSegundos(Integer.parseInt(request.getParameter("segundos")));	
		
		pontoGeograficoDAO.grava(pontoGeografico);
		
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adicionado.jsp");
		
		requestDispatcher.forward(request, response);
	}

}
