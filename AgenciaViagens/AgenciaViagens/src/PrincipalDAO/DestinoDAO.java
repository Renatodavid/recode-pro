package PrincipalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Principal.Destino;

public class DestinoDAO {
	private static String sql;

	private final Connection connection;

	public DestinoDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createDestino(Destino destino) {
		sql = "INSERT INTO destino (nome_destino, valor, data_saida, data_chegada, hora_partida, hora_chegada ,usu_id ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, destino.getNome_destino());
			stmt.setDouble(2, destino.getValor());
			stmt.setString(3, destino.getData_chegada());
			stmt.setString(4, destino.getData_saida());
			stmt.setString(5, destino.getHora_chegada());
			stmt.setString(6, destino.getHora_partida());
			stmt.setInt(7, destino.getUsu_id());

			stmt.executeUpdate();
			System.out.println("Destino criado com sucesso");
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possivel criar o seu Destino." + e);

		}
	}

	public void readDestino(int destino_id) {
		sql = "SELECT * FROM destino WHERE destino_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, destino_id);
			ResultSet r = stmt.executeQuery();

			while (r.next()) {
				Destino destino = new Destino();
				destino.setDestino_id(r.getInt("destino_id"));
	            destino.setNome_destino(r.getString("nome_destino"));
	            destino.setValor(r.getDouble("valor"));
	            destino.setData_saida(r.getString("data_saida"));
	            destino.setData_chegada(r.getString("data_chegada"));
	            destino.setHora_partida(r.getString("hora_partida"));
	            destino.setHora_chegada(r.getString("hora_chegada"));
	            destino.setUsu_id(r.getInt("usu_id"));
	            
	            
	            System.out.println("╔══════════════════════════════════════╗");
				System.out.println("║       Informações do Usuário         ║");
				System.out.println("╠══════════════════════════════════════╣");
				System.out.println("║ Id: " + destino.getDestino_id() + "                                ║");
				System.out.println("║ Destino: " + destino.getNome_destino() + "                      ║");
				System.out.println("║ Valor: " + destino.getValor() + "                         ║");
				System.out.println("║ Data Saida: " + destino.getData_saida() + "               ║");
				System.out.println("║ Data Chegada: " + destino.getData_chegada() + "             ║");
				System.out.println("║ Horario saída: " + destino.getHora_partida() + "              ║");
				System.out.println("║ Horario de chegada: " + destino.getHora_chegada() + "         ║");
				System.out.println("║ Usuario ID: " + destino.getUsu_id() + "                        ║");
				System.out.println("╚══════════════════════════════════════╝");

	            
	            
			}
			if (!r.next()) {
				
			}
		} catch (SQLException e) {
			System.out.println("Não foi possivel acessar as informções"+ e);
		}

	}

	public void updateDestino(Destino destino) {
		sql = "UPDATE destino SET nome_destino = ?, valor = ?, data_saida = ?, data_chegada = ? ,hora_partida = ? ,hora_chegada = ? WHERE nome_destino = ? ";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, destino.getNome_destino());
			stmt.setDouble(2, destino.getValor());
			stmt.setString(3, destino.getData_chegada());
			stmt.setString(4, destino.getData_saida());
			stmt.setString(5, destino.getHora_chegada());
			stmt.setString(6, destino.getHora_partida());
			stmt.setInt(7, destino.getUsu_id());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Destino atualizado com sucesso");
			} else {
				System.out.println("Nenhum Destino foi atualizado. Verifique o nome_destino fornecido.");
			}
		} catch (SQLException e) {
			System.out.println("Erro encontrado: " + e.getMessage());
		}
	}

	// delete
	public void deleteDestino(int id) {
		sql = "DELETE FROM destino WHERE destino_id = ? ";
		try (PreparedStatement s = connection.prepareStatement(sql)) {
			s.setInt(1, id);
			s.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" deletar");
		}
	}

}
