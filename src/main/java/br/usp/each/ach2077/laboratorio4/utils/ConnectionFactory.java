package br.usp.each.ach2077.laboratorio4.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		final String url = "jdbc:postgresql://143.107.58.177:5432/dbgrupo50";
		final String usuario = "grupo50";
		final String senha = "51r3g";

		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (final Exception e) {
			throw new RuntimeException(e);
			
		}
	}

}
