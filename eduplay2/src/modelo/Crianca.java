
package modelo;
                   
public class Crianca {
    private String nome;
    private String cpf;
    private int idade;
    private Instituicoes instituicao;
    private Responsavel responsavel;

    public Crianca(String nome, String cpf, int idade, Responsavel responsavel, Instituicoes instituicao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.responsavel = responsavel;
        this.instituicao = instituicao;
    }
    
    public Instituicoes getInstituicao() {
        return instituicao;
    }
    
    public Responsavel getResponsavel() {
        return responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    // CORRIGIDO: Nome do método alterado de setPeso para setCpf
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Crianca{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                '}';
    }
}