import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gerente {
	private String senha;
	private Map<String, Cliente> clientes;

	public Gerente(String senha) {
		this.senha = senha;
		this.clientes = new HashMap<>();
	}

	public boolean autenticarGerente(String senha) {
		return this.senha.equals(senha);
	}

	public void operarComoGerente() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n=== Menu do Gerente ===");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("2. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();

			if (opcao == 1) {
				cadastrarCliente(scanner);
			} else if (opcao == 2) {
				System.out.println("Saindo do menu do gerente...");
				return;
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private void cadastrarCliente(Scanner scanner) {
		System.out.print("Digite o CPF do cliente: ");
		String cpf = scanner.next();
		System.out.print("Digite a senha do cliente: ");
		String senha = scanner.next();
		if (!clientes.containsKey(cpf)) {
			clientes.put(cpf, new Cliente(cpf, senha));
			System.out.println("Cliente cadastrado com sucesso.");
		} else {
			System.out.println("Cliente já cadastrado.");
		}
	}

	public void carregarClientes(String clientesFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(clientesFile))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(",");
				String cpf = dados[0];
				String senha = dados[1];
				clientes.put(cpf, new Cliente(cpf, senha));
			}
		} catch (IOException e) {
			System.out.println("Erro ao carregar os clientes: " + e.getMessage());
		}
	}

	public void salvarClientes(String clientesFile) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(clientesFile))) {
			for (Cliente cliente : clientes.values()) {
				bw.write(cliente.getCpf() + "," + cliente.getSenhaHash());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao salvar os clientes: " + e.getMessage());
		}
	}
}
