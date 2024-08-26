package view;

import dao.PessoaDao;
import model.Pessoa;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            // Exibe o menu de opções
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Deletar Pessoa");
            System.out.println("3. Listar Pessoas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();

                    if (pessoaDao.buscarPorEmail(email)) {
                        System.out.println("Email já existe.");
                    } else {
                        Pessoa pessoa = new Pessoa(nome, email);
                        if (pessoaDao.salvar(pessoa)) {
                            System.out.println("Pessoa salva com sucesso.");
                        } else {
                            System.out.println("Erro ao salvar pessoa.");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Digite o e-mail para deletar: ");
                    String emailDelete = scanner.nextLine();
                    if (pessoaDao.deletarPorEmail(emailDelete)) {
                        System.out.println("Pessoa deletada com sucesso!");
                    } else {
                        System.out.println("Nenhuma pessoa encontrada com esse e-mail.");
                    }
                    break;
                case 3:
                    Set<Pessoa> pessoas = pessoaDao.getPessoas();
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        System.out.println("Lista de Pessoas:");
                        for (Pessoa p : pessoas) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
