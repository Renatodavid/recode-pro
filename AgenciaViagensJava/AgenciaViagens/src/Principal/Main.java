package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import PrincipalDAO.DestinoDAO;
import PrincipalDAO.UsuarioDAO;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		UsuarioDAO usuarioDAO = null;
		Connection connection = null;

		int option = 0;

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenciaviagens", "renatodavid",
					"sff1jsff1j");

			usuarioDAO = new UsuarioDAO(connection);
			var destinoDAO = new DestinoDAO(connection);

			do {
				System.out.println("╔══════════════════════════════════╗");
				System.out.println("║           Menu Principal         ║");
				System.out.println("╠══════════════════════════════════╣");
				System.out.println("║         1 - Criar Usuario        ║");
				System.out.println("║         2 - Ler Usuario          ║");
				System.out.println("║         3 - Atualizar usuario    ║");
				System.out.println("║         4 - Deletar Usuario      ║");
				System.out.println("║         5 - Criar Destino        ║");		
				System.out.println("║         6 - Ler Destino          ║");
				System.out.println("║         7 - Atualizar Destino    ║");
				System.out.println("║         8 - Deletar Destino      ║");
				System.out.println("║         9 - Sair                 ║");
				System.out.println("╚══════════════════════════════════╝");

				System.out.print("         Escolha uma opção: ");

				option = scanner.nextInt();
					//criandoUsuario
				switch (option) {
				case 1:
					scanner.nextLine();
					Usuario usuario = new Usuario();
					System.out.println();
					usuario.setusuId(10);
					System.out.println("Cel/Tel: ");
					usuario.setCelular(scanner.next());
					scanner.nextLine();
					System.out.println("Nome Completo: ");
					usuario.setnomeUsuario(scanner.next());
					scanner.nextLine();
					System.out.println("Digite seu CPF: ");
					usuario.setCpf(scanner.next());
					scanner.nextLine();
					System.out.println("email: ");
					usuario.setEmail(scanner.next());
					scanner.nextLine();
					System.out.println("Cria sua senha: ");
					usuario.setSenha(scanner.next());
					scanner.nextLine();
					System.out.println("Genero:M|F|Outro ");
					usuario.setGenero(scanner.next());
					scanner.nextLine();
					System.out.println("Endereço: ");
					usuario.setEndereco(scanner.nextLine());
					scanner.nextLine();
					usuarioDAO.createUsuario(usuario);
					scanner.nextLine();				
					break;
				case 2:
					//lerUsuario
					usuarioDAO.readUsuario(1);
					break;
					//atualizandoUsuario
				case 3:
					Usuario usuarioAtualizado = new Usuario();
					System.out.println("Digite o ID do cliente a ser atualizado: ");
					usuarioAtualizado.setusuId(scanner.nextInt());
					scanner.nextLine();
					System.out.println("Nome Completo: ");
					usuarioAtualizado.setnomeUsuario(scanner.next());
					scanner.nextLine();
					System.out.println("CPF: ");
					usuarioAtualizado.setCpf(scanner.next());
					scanner.nextLine();
					System.out.println("Email: ");
					usuarioAtualizado.setEmail(scanner.next());
					scanner.nextLine();
					System.out.println("senha: ");
					usuarioAtualizado.setSenha(scanner.next());
					scanner.nextLine();
					System.out.println("Genero: ");
					usuarioAtualizado.setGenero(scanner.next());
					scanner.nextLine();
					System.out.println("Endereço: ");
					usuarioAtualizado.setEndereco(scanner.next());
					scanner.next();
					System.out.println("Telefone: ");
					usuarioAtualizado.setCelular(scanner.next());
					usuarioDAO.updateUsuario(usuarioAtualizado);
					break;
						//deletandoUsuario
				case 4:
					System.out.println("Digite o ID do Cliente a ser DELETADO: ");
					int idUsuario = scanner.nextInt();
					usuarioDAO.excluirUsuario(idUsuario);
					break;
				// createDestino
				case 5:
					Destino createDestino = new Destino();
					System.out.println("Digite seu Destino");
					createDestino.setNome_destino(scanner.next());
					System.out.println("Valor");
					createDestino.setValor(scanner.nextDouble());
					System.out.println("Data  estimada da saida");
					createDestino.setData_saida(scanner.next());
					System.out.println("Data estimada da chegada");
					createDestino.setData_chegada(scanner.next());
					System.out.println("Hora aproximada de partir");
					createDestino.setHora_partida(scanner.next());
					System.out.println("Hora aproximada de chegada");
					createDestino.setHora_chegada(scanner.next());
					System.out.println("informe o Número do usuario cadastrado ");
					createDestino.setUsu_id(scanner.nextInt());
					destinoDAO.createDestino(createDestino);
					break;
				// readdestino
				case 6:
					
					destinoDAO.readDestino(3 );
					break;
				case 7:
					// atualizardestino
					Destino destinoAtualizado = new Destino();
					System.out.println("Digite o ID do Destino a ser atualizado: ");
					destinoAtualizado.setDestino_id(scanner.nextInt());
					scanner.nextLine();
					System.out.println("Nome do Destino: ");
					destinoAtualizado.setNome_destino(scanner.next());
					scanner.nextLine();
					System.out.println("Alterar Valor: ");
					destinoAtualizado.setValor(scanner.nextDouble());
					scanner.nextLine();
					System.out.println("Dia de saida: ");
					destinoAtualizado.setData_saida(scanner.next());
					scanner.nextLine();
					System.out.println("Data da chegada: ");
					destinoAtualizado.setData_chegada(scanner.next());
					scanner.nextLine();
					System.out.println("Horario disponivel: ");
					destinoAtualizado.setHora_partida(scanner.next());
					scanner.nextLine();
					System.out.println("Novo horario de chegada: ");
					destinoAtualizado.setHora_chegada(scanner.next());
					scanner.next();
					System.out.println("Usu_id: ");
					destinoAtualizado.setUsu_id(scanner.nextInt());
					break;
				case 8:
					//deletarDestino
					System.out.println("Digite o ID do Destino a ser DELETADO: ");
					int nome_destino = scanner.nextInt();
					destinoDAO.deleteDestino(nome_destino);
					break;
				case 9:
					System.out.println("Saindo do sistema...");
					scanner.close();
					System.exit(0);
				default:
					break;
				}

			} while (option != 9);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
