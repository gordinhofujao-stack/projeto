package modelo;

public class Responsavel {

    private int idaderesponsavel;
    private String responsavel;
    private String cpfresponsavel;

    public Responsavel(String responsavel, String cpfresponsavel, int idaderesponsavel) {
        this.idaderesponsavel = idaderesponsavel;
        this.responsavel = responsavel;
        this.cpfresponsavel = cpfresponsavel;
    }

    public int getIdaderesponsavel() {
        return idaderesponsavel;
    }

    public void setIdaderesponsavel(int idaderesponsavel) {
        this.idaderesponsavel = idaderesponsavel;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCpfresponsavel() {
        return cpfresponsavel;
    }

    public void setCpfresponsavel(String cpfresponsavel) {
        this.cpfresponsavel = cpfresponsavel;
    }

    @Override
    public String toString() {
        return "Responsavel " +
               "nome:'" + responsavel + '\'' +
               ", cpf:'" + cpfresponsavel + '\'' +
               ", idade:" + idaderesponsavel +
               '}';
    }
}