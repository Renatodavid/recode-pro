package Principal;

import java.sql.Connection;

public class Destino {

	private int destino_id;
	private Double valor;
	private String data_saida;
	private String data_chegada;
	private String hora_partida;
	private String hora_chegada;
	private int usu_id;
	private String nome_destino;

	public Destino(int destino_id, Double valor, String data_saida, String data_chegada, String hora_partida,
			String hora_chegada, int usu_id, String nome_destino) {
		super();
		this.destino_id = destino_id;
		this.valor = valor;
		this.data_saida = data_saida;
		this.data_chegada = data_chegada;
		this.hora_partida = hora_partida;
		this.hora_chegada = hora_chegada;

		this.nome_destino = nome_destino;
	}

	public Destino(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	public Destino() {
		// TODO Auto-generated constructor stub
	}

	public int getDestino_id() {
		return destino_id;
	}

	public void setDestino_id(int destino_id) {
		this.destino_id = destino_id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getData_saida() {
		return data_saida;
	}

	public void setData_saida(String data_saida) {
		this.data_saida = data_saida;
	}

	public String getData_chegada() {
		return data_chegada;
	}

	public void setData_chegada(String data_chegada) {
		this.data_chegada = data_chegada;
	}

	public String getHora_partida() {
		return hora_partida;
	}

	public void setHora_partida(String hora_partida) {
		this.hora_partida = hora_partida;
	}

	public String getHora_chegada() {
		return hora_chegada;
	}

	public void setHora_chegada(String hora_chegada) {
		this.hora_chegada = hora_chegada;
	}

	public int getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}

	public String getNome_destino() {
		return nome_destino;
	}

	public void setNome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}

}