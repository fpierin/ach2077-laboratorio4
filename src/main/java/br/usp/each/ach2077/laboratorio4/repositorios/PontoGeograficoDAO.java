package br.usp.each.ach2077.laboratorio4.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usp.each.ach2077.laboratorio4.representacoes.PontoGeografico;
import br.usp.each.ach2077.laboratorio4.utils.ConnectionFactory;

public class PontoGeograficoDAO {

	private static final String SQL_EXCLUIR_PONTO_GEOGRAFICO = 		
		"delete from \"ponto_geografico\" where \"idponto\" = ?";

	private static final String SQL_LISTA_PONTOS_GEOGRAFICOS = 
		"select * from \"ponto_geografico\"";

	private static final String SQL_GRAVA_PONTO_GEOGRAFICO = 
		"insert into \"ponto_geografico\" (\"idponto\", \"nomeponto\", \"graus\", \"minutos\", \"segundos\")" +
		" values (?, ?, ?, ?, ?)";
	
	private final Connection connection;

	public PontoGeograficoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<PontoGeografico> getLista(){
		try{
			List<PontoGeografico> pontosGeograficos = null;
			pontosGeograficos = new ArrayList<PontoGeografico>();
			final PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_LISTA_PONTOS_GEOGRAFICOS);
			final ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				final PontoGeografico pontoGeografico = new PontoGeografico();
				pontoGeografico.setGraus(resultSet.getInt("graus"));
				pontoGeografico.setId(resultSet.getInt("IdPonto"));
				pontoGeografico.setMinutos(resultSet.getInt("minutos"));
				pontoGeografico.setNome(resultSet.getString("NomePonto"));
				pontoGeografico.setSegundos(resultSet.getInt("segundos"));
				pontosGeograficos.add(pontoGeografico);
			}
			resultSet.close();
			preparedStatement.close();
			return pontosGeograficos;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	public void grava(final PontoGeografico pontoGeografico){
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(SQL_GRAVA_PONTO_GEOGRAFICO);
			preparedStatement.setInt(1, pontoGeografico.getId());		
			preparedStatement.setString(2, pontoGeografico.getNome());
			preparedStatement.setInt(3, pontoGeografico.getGraus());
			preparedStatement.setInt(4, pontoGeografico.getMinutos());
			preparedStatement.setInt(5, pontoGeografico.getSegundos());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}			
	}
	
	public void remove(final PontoGeografico pontoGeografico){
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXCLUIR_PONTO_GEOGRAFICO);
			preparedStatement.setInt(1, pontoGeografico.getId());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}			
	}

}
