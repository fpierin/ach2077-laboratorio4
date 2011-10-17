package br.usp.each.ach2077.laboratorio4.representacoes;

public class PontoGeografico {

	private int id;
	
	private String nome;
	
	private int graus;
	
	private int minutos;
	
	private int segundos;

	public PontoGeografico() {}
	
	public PontoGeografico(int id, String nome, int graus, int minutos, int segundos) {
		this.id = id;
		this.nome = nome;
		this.graus = graus;
		this.minutos = minutos;
		this.segundos = segundos;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getGraus() {
		return graus;
	}

	public void setGraus(int graus) {
		this.graus = graus;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	
}
