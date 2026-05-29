package array;

import modelo.Crianca;

public class CadastroService implements IOperacoes {

    private Crianca[] criancas;
    private int quantidade;
    private static final int CAPACIDADE_INICIAL = 5;

    public CadastroService() {
        this.criancas = new Crianca[CAPACIDADE_INICIAL];
        this.quantidade = 0;
    }

    @Override
    public boolean inserir(Crianca crianca) {
        if (crianca == null) {
            return false;
        }
        if (quantidade == criancas.length) {
            redimensionar();
        }
        criancas[quantidade] = crianca;
        quantidade++;
        return true;
    }

    // Cria um novo array 50% maior, copia os elementos e atualiza a referencia
    private void redimensionar() {
        int novoTamanho = criancas.length + (criancas.length / 2);
        if (novoTamanho == criancas.length) {
            novoTamanho++;
        }
        Crianca[] novoArray = new Crianca[novoTamanho];
        for (int i = 0; i < quantidade; i++) {
            novoArray[i] = criancas[i];
        }
        criancas = novoArray;
    }

    @Override
    public Crianca pesquisar(Crianca crianca) {
        if (crianca == null) {
            return null;
        }
        int indice = pesquisarIndice(crianca.getId());
        if (indice == -1) {
            return null;
        }
        return criancas[indice];
    }

    // Metodo privativo: retorna o indice da crianca pelo id
    private int pesquisarIndice(int id) {
        for (int i = 0; i < quantidade; i++) {
            if (criancas[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remover(int id) {
        int indice = pesquisarIndice(id);
        if (indice == -1) {
            return false;
        }
        for (int i = indice; i < quantidade - 1; i++) {
            criancas[i] = criancas[i + 1];
        }
        criancas[quantidade - 1] = null;
        quantidade--;
        return true;
    }

    @Override
    public boolean atualizar(int id, String novaTurma) {
        int indice = pesquisarIndice(id);
        if (indice == -1) {
            return false;
        }
        criancas[indice].setTurma(novaTurma);
        return true;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String listar() {
        if (quantidade == 0) {
            return "Nenhuma crianca cadastrada.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quantidade; i++) {
            sb.append(criancas[i].toString()).append("\n");
        }
        return sb.toString();
    }
}