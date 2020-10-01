package matheus.senai.projetocantina;

public class Produto {

    private String nome;
    private String descricao;
    private String vencimento;
    private String preco;

    //Construtor Vazio
    public  Produto(){

    }

    public Produto(String nome, String descricao, String vencimento, String preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.vencimento = vencimento;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
