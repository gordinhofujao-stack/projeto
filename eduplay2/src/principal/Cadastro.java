package principal;

import estruturaDados.*;
import java.util.Scanner;
import modelo.*;

public class Cadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Array bancoDados = new Array();
        
        // Dados de teste iniciais
        Responsavel respTeste = new Responsavel("Jane Cristina da Silva", "321.321.234-12", 19);
        Instituicoes instTeste = new Instituicoes("anhembimorumbi", "654.654.654-65");
        
        // Ajustado para o construtor correto da classe Crianca: (nome, cpf, idade, responsavel, instituicao)
        bancoDados.inserirCrianca(new Crianca("Pedro", "123.123.123-12", 12, respTeste, instTeste));
        bancoDados.inserirResponsavel(respTeste);
        bancoDados.inserirInstituicao(instTeste);
            
        while (true) {
            System.out.println("==============================================================================");
            System.out.println("                                ----- SISTEMA -----");
            System.out.println("1) Cadastrar alunos");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("2) ver responsaveis por aluno");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("3) ver alunos");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("4) procurar aluno");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("5) cadastrar instituição");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("0) sair");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("  Escolha: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer
           
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    return;

                case 1:
                    System.out.println("==============================================================================");
                    System.out.println("Em qual instituição quer cadastrar o aluno?");
                    System.out.println("1) Anhembi Morumbi");
                    System.out.println("2) Outra Instituição");
                    System.out.print("Escolha: ");
                    
                    int opcaoInstituicao = scanner.nextInt();
                    scanner.nextLine(); // Limpa buffer

                    Instituicoes instituicaoEscolhida = null;

                    switch (opcaoInstituicao) {
                        case 1:
                            instituicaoEscolhida = instTeste; // Reaproveita a instituição padrão cadastrada no início
                            System.out.println("-> Selecionado: Anhembi Morumbi");
                            break;
                        case 2:
                            System.out.print("Digite o nome da nova instituição: ");
                            String nomeNova = scanner.nextLine();
                            System.out.print("Digite o CNPJ da nova instituição: ");
                            String cnpjNova = scanner.nextLine();
                            
                            instituicaoEscolhida = new Instituicoes(nomeNova, cnpjNova);
                            bancoDados.inserirInstituicao(instituicaoEscolhida);
                            break;
                        default:
                            System.out.println("Opção inválida! Usando Anhembi Morumbi por padrão.");
                            instituicaoEscolhida = instTeste;
                            break;
                    }

                    System.out.println("------------------------------------------------------------------------------");
                    
                    // --- DADOS DA CRIANÇA ---
                    String nome1crianca = lerNome(scanner, "Primeiro nome da criança: ");
                    String nome2crianca = lerNome(scanner, "Segundo nome da criança: ");
                    String nome3crianca = lerNome(scanner, "Terceiro nome da criança: ");
                    String nomecrianca = montarnome(nome1crianca, nome2crianca, nome3crianca);

                    int idadecrianca;
                    do {
                        System.out.print("Idade da criança: ");
                        idadecrianca = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer

                        if (idadecrianca < 0 || idadecrianca > 17) {
                            System.out.println("Idade inválida! Digite entre 0 e 17.");
                        }
                    } while (idadecrianca < 0 || idadecrianca > 17);

                    System.out.println("Digite o CPF da criança:");
                    String cpf1crianca = lerCpf(scanner, 3, "3 primeiros dígitos: ");
                    String cpf2crianca = lerCpf(scanner, 3, "3 dígitos do meio: ");
                    String cpf3crianca = lerCpf(scanner, 3, "3 dígitos finais: ");
                    String cpf4crianca = lerCpf(scanner, 2, "2 últimos dígitos: ");
                    String cpfcrianca = montarCpf(cpf1crianca, cpf2crianca, cpf3crianca, cpf4crianca);

                    System.out.println("==============================================================================");

                    // --- DADOS DO RESPONSÁVEL ---
                    String nome1responsavel = lerNome(scanner, "Primeiro nome do responsável: ");
                    String nome2responsavel = lerNome(scanner, "Segundo nome do responsável: ");
                    String nome3responsavel = lerNome(scanner, "Terceiro nome do responsável: ");
                    String nomeresponsavel = montarnome(nome1responsavel, nome2responsavel, nome3responsavel);

                    int idaderesponsavel;
                    do {
                        System.out.print("Idade do responsável: ");
                        idaderesponsavel = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer

                        if (idaderesponsavel < 18) {
                            System.out.println("Responsável deve ter 18 anos ou mais.");
                        }
                    } while (idaderesponsavel < 18);

                    System.out.println("Digite o CPF do responsável:");
                    String cpf1responsavel = lerCpf(scanner, 3, "3 primeiros dígitos: ");
                    String cpf2responsavel = lerCpf(scanner, 3, "3 dígitos do meio: ");
                    String cpf3responsavel = lerCpf(scanner, 3, "3 dígitos finais: ");
                    String cpf4responsavel = lerCpf(scanner, 2, "2 últimos dígitos: ");
                    String cpfresponsavel = montarCpf(cpf1responsavel, cpf2responsavel, cpf3responsavel, cpf4responsavel);
                    
                    System.out.println("==============================================================================");

                    // --- INSTANCIAÇÃO E SALVAMENTO ---
                    Responsavel novoResp = new Responsavel(nomeresponsavel, cpfresponsavel, idaderesponsavel);
                    bancoDados.inserirResponsavel(novoResp);
                    
                    Crianca novaCrianca = new Crianca(nomecrianca, cpfcrianca, idadecrianca, novoResp, instituicaoEscolhida);
                    bancoDados.inserirCrianca(novaCrianca);

                    System.out.println("Nome da Criança: " + nomecrianca + " | Idade: " + idadecrianca + " | CPF: " + cpfcrianca);
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Nome do Responsável: " + nomeresponsavel + " | Idade: " + idaderesponsavel + " | CPF: " + cpfresponsavel);
                    System.out.println("Instituição: " + instituicaoEscolhida.getNomeinstituicao()); 
                    
                    System.out.println("==============================================================================");
                    System.out.println("\nAluno e Responsável cadastrados com sucesso!");
                    break;
                    
                case 2:
                    System.out.println("==============================================================================");
                    System.out.println("                ----- RESPONSÁVEIS POR ALUNO CADASTRADOS -----");
                    bancoDados.exibirResponsaveisPorAluno(); 
                    System.out.println("==============================================================================");
                    break;

                case 3:
                    System.out.println("==============================================================================");
                    System.out.println("                        ----- ALUNOS CADASTRADOS -----");
                    bancoDados.exibirCriancas();
                    System.out.println("==============================================================================");
                    break;

                case 4:
                    System.out.println("==============================================================================");
                    System.out.println("                        ----- PROCURAR ALUNOS -----");
                    System.out.println("1) Alunos por Instituição");
                    System.out.println("2) Alunos por CPF");
                    System.out.print("Escolha: ");
                    
                    int subOpcao = scanner.nextInt();
                    scanner.nextLine(); // Limpa buffer

                    if (subOpcao == 1) {
                        System.out.print("Digite o nome da instituição para filtrar: ");
                        String nomeFiltro = scanner.nextLine();
                        bancoDados.exibirAlunosPorNomeInstituicao(nomeFiltro);
                    } else if (subOpcao == 2) {
                        System.out.println("Digite o CPF do aluno para busca (completo no formato XXX.XXX.XXX-XX):");
                        String cpfBusca = scanner.nextLine();
                        System.out.println("------------------------------------------------------------------------------");
                        bancoDados.buscarAlunoPorCpf(cpfBusca); 
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    System.out.println("==============================================================================");
                    break;

                case 5:
                    System.out.println("==============================================================================");
                    System.out.println("                      ----- CADASTRAR INSTITUIÇÃO -----");
                    System.out.print("Nome da Instituição: ");
                    String nInst = scanner.nextLine();
                    System.out.print("CNPJ da Instituição: ");
                    String cInst = scanner.nextLine();
                    
                    Instituicoes instManual = new Instituicoes(nInst, cInst);
                    bancoDados.inserirInstituicao(instManual);
                    System.out.println("Instituição cadastrada com sucesso!");
                    System.out.println("==============================================================================");
                    break;

                default:
                    System.out.println("Opção inválida! Selecione uma opção de 0 a 5.");
                    break;
            }
        }
    }

    // --- MÉTODOS AUXILIARES ---

    public static boolean blocoValido(String parte, int tamanho) {
        return parte.matches("\\d{" + tamanho + "}");
    }

    public static String lerCpf(Scanner sc, int tamanho, String msg) {
        String cpf;
        do {
            System.out.print(msg);
            cpf = sc.nextLine().trim();

            if (!blocoValido(cpf, tamanho)) {
                System.out.println("CPF inválido! Digite somente números com a quantidade correta de dígitos.");
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
            nome = sc.nextLine().trim();

            if (nome.isBlank()) {
                System.out.println("Nome vazio! Por favor, digite um nome.");
                continue;
            }

            if (!nomeValido(nome)) {
                System.out.println("Nome inválido! Não pode conter números ou caracteres especiais.");
            }

        } while (nome.isBlank() || !nomeValido(nome));

        return nome;
    }

    public static String montarCpf(String p1, String p2, String p3, String p4) {
        return p1 + "." + p2 + "." + p3 + "-" + p4;
    }

    public static String montarnome(String p1, String p2, String p3) {
        return p1 + " " + p2 + " " + p3;
    }
}