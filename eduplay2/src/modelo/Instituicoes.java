package modelo;

public class Instituicoes {

    private String nomeinstituicao;
    private String cnpj;

    public Instituicoes(String nomeinstituicao,String cnpj) {
        
        this.nomeinstituicao = nomeinstituicao;
        this.cnpj = cnpj;
    }

    public String getNomeinstituicao() {
        return nomeinstituicao;
    }

    public void setNomeinstituicao(String nomeinstituicao) {
        this.nomeinstituicao = nomeinstituicao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() +"nomeinstituicao='" + nomeinstituicao + '\'' +", cnpj='" + cnpj + '\'' ;}
}
