package principal;

import modelo.*;
import array.*;

import java.util.Scanner;

public class Cadastro {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CadastroService service = new CadastroService();

        int opcao;
        
        while (true) {


        System.out.println("==============================================================================");
        System.out.println("                                ----- SISTEMA -----");
        System.out.println("1) Cadastrar aluno");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("2) Ver alunos");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("3) remover aluno");
        System.out.println("------------------------------------------------------------------------------");        
        System.out.println("4) editar aluno");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("5) buscar por CPF");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("0) Sair");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("  Escolha: ");
        opcao = scanner.nextInt();
        scanner.nextLine();
        switch(opcao) {
            
            case 0: System.out.println("Encerrando sistema...");
           
                        scanner.close();return;

            case 1:
    System.out.println("==============================================================================");

                System.out.println("Digite o nome da criança");
                
    String nome1crianca = lerNome(scanner, "Primeiro nome da criança: ");
    
    String nome2crianca = lerNome(scanner, "Segundo nome da criança: ");
    
    String nome3crianca = lerNome(scanner, "Terceiro nome da criança: ");

    String nomecrianca = montarnome(nome1crianca, nome2crianca, nome3crianca);
    
    
        System.out.println("------------------------------------------------------------------------------");

                    System.out.println("Digite o cpf da criança");

    
    String cpf1crianca = lerCpf(scanner, 3, "3 primeiros dígitos: ");
    String cpf2crianca = lerCpf(scanner, 3, "3 dígitos do meio: ");
    String cpf3crianca = lerCpf(scanner, 3, "3 dígitos finais: ");
    String cpf4crianca = lerCpf(scanner, 2, "2 últimos dígitos: ");

    String cpfcrianca = montarCpf(cpf1crianca, cpf2crianca, cpf3crianca, cpf4crianca);

    int idadecrianca;

    do {
        System.out.print("Idade da criança: ");
        idadecrianca = scanner.nextInt();
        scanner.nextLine();

        if (idadecrianca < 0 || idadecrianca > 17) {
            System.out.println("Idade inválida! Digite entre 0 e 17.");
        }

    } while (idadecrianca < 0 || idadecrianca > 17);

    System.out.println("==============================================================================");
    
   
                    System.out.println("Digite o nome do Responsavel");
    String nome1responsavel = lerNome(scanner, "Primeiro nome do responsável: ");
    String nome2responsavel = lerNome(scanner, "Segundo nome do responsável: ");
    String nome3responsavel = lerNome(scanner, "Terceiro nome do responsável: ");

    String nomeresponsavel = montarnome(nome1responsavel, nome2responsavel, nome3responsavel);
    
       System.out.println("------------------------------------------------------------------------------");

                    System.out.println("Digite o cpf do Responsavel");
    String cpf1responsavel = lerCpf(scanner, 3, "3 primeiros dígitos: ");
    String cpf2responsavel = lerCpf(scanner, 3, "3 dígitos do meio: ");
    String cpf3responsavel = lerCpf(scanner, 3, "3 dígitos finais: ");
    String cpf4responsavel = lerCpf(scanner, 2, "2 últimos dígitos: ");
       System.out.println("------------------------------------------------------------------------------");

    String cpfresponsavel = montarCpf(cpf1responsavel, cpf2responsavel, cpf3responsavel, cpf4responsavel);

    int idaderesponsavel;

    do {
        
        System.out.print("Idade do responsável: ");
        idaderesponsavel = scanner.nextInt();
        scanner.nextLine();

        if (idaderesponsavel < 18) {
            System.out.println("Responsável deve ter 18 anos ou mais.");
        }

    } while (idaderesponsavel < 18);

    Responsavel responsavel = new Responsavel(nomeresponsavel, cpfresponsavel, idaderesponsavel);

    Crianca crianca = new Crianca(nomecrianca, cpfcrianca, idadecrianca, responsavel);

    service.adicionarAluno(crianca);

    System.out.println("Aluno cadastrado com sucesso!");

    break;
    
    case 2:
    service.listarAlunos();
    break;
    
case 3:
    System.out.print("CPF do aluno: ");
    String cpfEdit = scanner.nextLine();

    Crianca aluno = service.buscarPorCpf(cpfEdit);

    if (aluno != null) {

        System.out.print("Novo nome: ");
        aluno.setNome(scanner.nextLine());

        System.out.print("Nova idade: ");
        aluno.setIdade(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Aluno atualizado!");
    } else {
        System.out.println("Aluno não encontrado");
    }
    break;    
    case 4:
    System.out.print("Digite o CPF do aluno: ");
    String cpfRemover = scanner.nextLine();

    service.removerAluno(cpfRemover);

    System.out.println("Aluno removido!");
    break;
    
    case 5:
    System.out.print("CPF: ");
    String cpfBusca = scanner.nextLine();

    Crianca c = service.buscarPorCpf(cpfBusca);

    if (c != null) {
        System.out.println(c);
    } else {
        System.out.println("Aluno não encontrado");
    }
    break;
    
default:

                System.out.println("Opcao invalida");break;
        }

        }    
}
    public static boolean blocoValido(String parte, int tamanho) {return parte.matches("\\d{" + tamanho + "}");}
    public static String lerCpf(Scanner sc, int tamanho, String msg) {

    String cpf;

    do {
        System.out.print(msg);
        cpf = sc.nextLine();

        if (!blocoValido(cpf, tamanho)) {
            System.out.println("CPF inválido! Digite somente números.");
        }

    } while (!blocoValido(cpf, tamanho));

    return cpf;
}
    public static boolean nomeValido(String nome) {
        return nome.matches("[a-zA-ZÀ-ÿ\\s]+");
    }
    public static String lerNome(Scanner sc, String msg) {

        String nome;

        do {
            System.out.print(msg);
            nome = sc.nextLine();

            if (!nomeValido(nome)) {
                System.out.println("Nome inválido! Não pode conter números.");
            }

        } while (!nomeValido(nome));

        return nome;
    }    
    public static String montarCpf(String p1, String p2, String p3, String p4) {
    return p1 + "." + p2 + "." + p3 + "-" + p4;
}
    public static String montarnome(String p1, String p2, String p3) {
    return p1 + " " + p2 + " " + p3;
}

}
