package br.usp.each.ach2077.laboratorio4.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.each.ach2077.laboratorio4.modelo.Logica;
import br.usp.each.ach2077.laboratorio4.repositorios.PontoGeograficoDAO;
import br.usp.each.ach2077.laboratorio4.representacoes.PontoGeografico;

public class Remover implements Logica {

	private final PontoGeograficoDAO pontoGeograficoDAO;

	public Remover() {
		this.pontoGeograficoDAO = new PontoGeograficoDAO();
	}

	@Override
	public void executa(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		System.out.println("Removendo ponto geográfico...");
		
		final PontoGeografico pontoGeografico = new PontoGeografico();
		pontoGeografico.setId(Integer.parseInt(request.getParameter("id")));
		
		pontoGeograficoDAO.remove(pontoGeografico);
		
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/removido.jsp");
		requestDispatcher.forward(request, response);
	}

}
