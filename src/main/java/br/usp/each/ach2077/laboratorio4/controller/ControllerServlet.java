package br.usp.each.ach2077.laboratorio4.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.each.ach2077.laboratorio4.modelo.Logica;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 5950841972969490645L;
	
	protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException {
		final String classeDaLogica = request.getParameter("logica");
		final String nomeDaClasse = "br.usp.each.ach2077.laboratorio4.logicas." + classeDaLogica;
		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}

}
