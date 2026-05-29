
package modelo;
 
public class Responsavel {

    private String responsavel;
    private String cpf;
    private int idade;

    public Responsavel() {
    }

    public Responsavel(String responsavel, String cpf, int idade) {
        this.responsavel = responsavel;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return " Responsavel: " + responsavel +
               " | Idade: " + idade +
               " | CPF: " + cpf;
    }
}