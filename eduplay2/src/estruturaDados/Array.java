package estruturaDados;

import modelo.*;

public class Array {

    // Crianças
    private Crianca[] criancas = new Crianca[10];
    private int contCriancas = 0;

    // Responsáveis
    private Responsavel[] responsaveis = new Responsavel[10];
    private int contResponsaveis = 0;

    // Instituições
    private Instituicoes[] instituicoes = new Instituicoes[2];
    private int contInstituicoes = 0;

    // ==================== CRIANÇAS ====================

    public void inserirCrianca(Crianca crianca) {
        if (contCriancas == criancas.length) {
            criancas = novoArrayCriancas();
        }
        criancas[contCriancas++] = crianca;
    }

    private Crianca[] novoArrayCriancas() {
        Crianca[] novo = new Crianca[criancas.length + (criancas.length/2)];
        System.arraycopy(criancas, 0, novo, 0, criancas.length);
        return novo;
    }

    public void exibirCriancas() {
        if (contCriancas == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (int i = 0; i < contCriancas; i++) {
            System.out.println(criancas[i]);
        }
    }

    // ==================== RESPONSÁVEIS ====================

    public void inserirResponsavel(Responsavel responsavel) {
        if (contResponsaveis == responsaveis.length) {
            responsaveis = novoArrayResponsaveis();
        }
        responsaveis[contResponsaveis++] = responsavel;
    }

    private Responsavel[] novoArrayResponsaveis() {
        Responsavel[] novo = new Responsavel[responsaveis.length + (responsaveis.length/2)];
        System.arraycopy(responsaveis, 0, novo, 0, responsaveis.length);
        return novo;
    }

    public void exibirResponsaveis() {
        for (int i = 0; i < contResponsaveis; i++) {
            System.out.println(responsaveis[i]);
        }
    }
    
    public void exibirResponsaveisPorAluno() {
        if (contCriancas == 0) {
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }
        
        for (int i = 0; i < contCriancas; i++) {
            System.out.println("Aluno: " + criancas[i]);
            if (criancas[i].getResponsavel() != null) {
                System.out.println("Responsável: " + criancas[i].getResponsavel());
            } else {
                System.out.println("Responsável: Não vinculado.");
            }
            System.out.println("------------------------------------------------------------------------------");
        }
    }

    // ==================== INSTITUIÇÕES ====================

    public void inserirInstituicao(Instituicoes instituicao) {
        if (contInstituicoes == instituicoes.length) {
            instituicoes = novoArrayInstituicoes();
        }
        instituicoes[contInstituicoes++] = instituicao;
    }

    private Instituicoes[] novoArrayInstituicoes() {
        Instituicoes[] novo = new Instituicoes[instituicoes.length + (instituicoes.length/2)];
        System.arraycopy(instituicoes, 0, novo, 0, instituicoes.length);
        return novo;
    }

    public void exibirInstituicoes() {
        for (int i = 0; i < contInstituicoes; i++) {
            System.out.println(instituicoes[i]);
        }
    }
    
    // ==================== MÉTODOS DE BUSCA (CASE 4) ====================

    public void exibirAlunosPorNomeInstituicao(String nomeFiltro) {
        boolean encontrou = false;
        System.out.println("==============================================================================");
        System.out.println("Resultados para a instituição [" + nomeFiltro + "]:");
        System.out.println("------------------------------------------------------------------------------");
        
        for (int i = 0; i < contCriancas; i++) {
            Instituicoes instDoAluno = criancas[i].getInstituicao();
            
            if (instDoAluno != null && instDoAluno.getNomeinstituicao().equalsIgnoreCase(nomeFiltro)) {
                System.out.println("- " + criancas[i]);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado para esta instituição.");
        }
        System.out.println("==============================================================================");
    }

    // CORRIGIDO: Escopo de chaves consertado e retorno inserido no local correto
    public void buscarAlunoPorCpf(String cpfBusca) {
        for (int i = 0; i < contCriancas; i++) {
            if (criancas[i].getCpf().equals(cpfBusca)) {
                System.out.println("\n[Aluno Encontrado!]");
                System.out.println("Dados: " + criancas[i]);
                
                if (criancas[i].getResponsavel() != null) {
                    System.out.println("Responsável: " + criancas[i].getResponsavel());
                }
                if (criancas[i].getInstituicao() != null) { 
                    System.out.println("Instituição: " + criancas[i].getInstituicao().getNomeinstituicao());
                }
                return; // Para o método imediatamente ao encontrar
            }
        }
        // Se o for terminar e não der o return, significa que não achou:
        System.out.println("Aluno com o CPF " + cpfBusca + " não foi encontrado.");
    }
}