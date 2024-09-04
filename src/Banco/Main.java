import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Cliente> clientes = new HashMap<>();
        Gerente gerente = new Gerente("admin");

        // Carregar os dados de clientes e contas no início do programa
        gerente.carregarClientes("clientes.txt");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Sistema Bancário ===");
            System.out.println("1. Login como Gerente");
            System.out.println("2. Login como Cliente");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a senha do gerente: ");
                String senha = scanner.next();
                if (gerente.autenticarGerente(senha)) {
                    System.out.println("Login bem-sucedido!");
                    gerente.operarComoGerente();
                } else {
                    System.out.println("Senha incorreta.");
                }
            } else if (opcao == 2) {
                System.out.print("Digite seu CPF: ");
                String cpf = scanner.next();
                System.out.print("Digite sua senha: ");
                String senha = scanner.next();

                Cliente cliente = clientes.get(cpf);
                if (cliente != null && cliente.autenticar(senha)) {
                    System.out.println("Login bem-sucedido!");
                    cliente.selecionarContaEOperar();
                } else {
                    System.out.println("CPF ou senha incorretos.");
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        // Salvar os dados de clientes antes de sair
        gerente.salvarClientes("clientes.txt");
    }
}
