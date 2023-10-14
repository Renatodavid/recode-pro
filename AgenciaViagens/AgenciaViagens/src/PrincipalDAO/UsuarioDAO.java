package PrincipalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Principal.Usuario;

public class UsuarioDAO {
	private static String sql;

	private final Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createUsuario(Usuario usuario) {
		sql = "INSERT INTO usuario  (usu_id, celular, nome_usuario, cpf, email, senha, genero, endereco) VALUES (?, ?,?,?,?,?,?,? )";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, usuario.getusuId());
			stmt.setString(2, usuario.getCelular());
			stmt.setString(3, usuario.getnomeUsuario());
			stmt.setString(4, usuario.getCpf());
			stmt.setString(5, usuario.getEmail());
			stmt.setString(6, usuario.getSenha());
			stmt.setString(7, usuario.getGenero());
			stmt.setString(8, usuario.getEndereco());
			stmt.executeUpdate();

			System.out.println("Usuario criado com sucesso");
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possivel criar o usuario. Mensagem: " + e.getMessage());
		}
	}

	public void readUsuario(int usu_id) {
		sql = "SELECT * FROM usuario WHERE usu_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, usu_id);
			ResultSet u = stmt.executeQuery();
			while (u.next()) {
				Usuario usuario = new Usuario();
				usuario.setusuId(u.getInt("usu_id"));
				usuario.setCelular(u.getString("celular"));
				usuario.setnomeUsuario(u.getString("nome_usuario"));
				usuario.setCpf(u.getString("cpf"));
				usuario.setEmail(u.getString("email"));
				usuario.setSenha(u.getString("senha"));
				usuario.setGenero(u.getString("genero"));
				usuario.setEndereco(u.getString("endereco"));

				System.out.println("╔══════════════════════════════════════╗");
				System.out.println("║       Informações do Usuário         ║");
				System.out.println("╠══════════════════════════════════════╣");
				System.out.println("║ Nome: " + usuario.getnomeUsuario() + "                        ║");
				System.out.println("║ Celular: " + usuario.getCelular() + "                          ║");
				System.out.println("║ CPF: " + usuario.getCpf() + "                     ║");
				System.out.println("║ E-mail: " + usuario.getEmail() + "          ║");
				System.out.println("║ Senha: " + usuario.getSenha() + "                      ║");
				System.out.println("║ Gênero: " + usuario.getGenero() + "                            ║");
				System.out.println("║ Endereço: " + usuario.getEndereco() + "                        ║");
				System.out.println("╚══════════════════════════════════════╝");

			}

			if (!u.next()) {
				System.out.println("Deseja continuar ? ");
			}
		} catch (SQLException e) {
			System.out.println("Não foi possivel acessar as informações");
		}

	}

	public void updateUsuario(Usuario usuario) {
		sql = "UPDATE usuario SET celular = ?, nome_usuario = ?, cpf = ?, email = ?, senha = ?, genero = ?, endereco = ? WHERE usu_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getCelular());
			stmt.setString(2, usuario.getnomeUsuario());
			stmt.setString(3, usuario.getCpf());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getSenha());
			stmt.setString(6, usuario.getGenero());
			stmt.setString(7, usuario.getEndereco());
			stmt.setInt(8, usuario.getusuId());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Usuário atualizado com sucesso");
			} else {
				System.out.println("Nenhum usuário foi atualizado. Verifique o usuId fornecido.");
			}
		} catch (SQLException e) {
			System.out.println("Erro encontrado: " + e.getMessage());
		}
	}

	public void excluirUsuario(int id) {
		sql = "DELETE FROM usuario WHERE usu_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Usuario excluído com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro encontrado: " + e.getMessage());
		}
	}

	public void fecharConexao() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
