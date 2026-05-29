package modelo;

public class Crianca {

    private String nome;
    private String cpf;
    private int idade;
    private Responsavel responsavel;

    public Crianca(String nome, String cpf, int idade, Responsavel responsavel) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.responsavel = responsavel;
    }

    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    public int getIdade() { return idade; }

    public Responsavel getResponsavel() { return responsavel; }

    public void setNome(String nome) { this.nome = nome; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setIdade(int idade) { this.idade = idade; }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome +
               " | Idade: " + idade +
               " | CPF: " + cpf +
               " | Responsável: " + responsavel;
    }
}