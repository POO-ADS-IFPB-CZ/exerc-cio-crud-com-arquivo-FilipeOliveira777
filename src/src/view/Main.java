package view;
<<<<<<< HEAD

=======
>>>>>>> origin/main
import dao.PessoaDao;
import model.Pessoa;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();
        Scanner scanner = new Scanner(System.in);

<<<<<<< HEAD
=======

        Set<Pessoa> pessoas = pessoaDao.getPessoas();
>>>>>>> origin/main
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
<<<<<<< HEAD
            scanner.nextLine(); // Limpar o buffer de entrada
=======
            scanner.nextLine();
>>>>>>> origin/main

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
<<<<<<< HEAD
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
=======
                    System.out.println("Digite  o email");
                    String email = scanner.nextLine();

                    if(pessoaDao.buscarPorEmail(email)){
                        System.out.println("Email ja existe");
                    }else{
                        Pessoa pessoa = new Pessoa(nome, email);

                        if(pessoaDao.salvar(pessoa)){
                            System.out.println("Pessoa salva com sucesso");
                        }
                        else{
                            System.out.println("Erro ao salvar Pessoa");
>>>>>>> origin/main
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
<<<<<<< HEAD
                    Set<Pessoa> pessoas = pessoaDao.getPessoas();
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        System.out.println("Lista de Pessoas:");
                        for (Pessoa p : pessoas) {
                            System.out.println(p);
                        }
=======
                    Set<Pessoa> pessoasP = pessoaDao.getPessoas();
                    for (Pessoa p : pessoasP) {
                        System.out.println(p);
>>>>>>> origin/main
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
<<<<<<< HEAD
        } while (opcao != 4);

        scanner.close();
=======
        }
            while (opcao != 4) ;

            scanner.close();
>>>>>>> origin/main
    }
}
