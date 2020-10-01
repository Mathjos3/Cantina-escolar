package matheus.senai.projetocantina;

public class Cardapio {

    private String DiaSemana;
    private String Nome;
    private String Composicao;
    private String Preco;

    //Construtor
    public Cardapio(String diaSemana, String nome, String composicao, String preco) {
        DiaSemana = diaSemana;
        Nome = nome;
        Composicao = composicao;
        Preco = preco;
    }

    public String getDiaSemana() {
        return DiaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        DiaSemana = diaSemana;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String preco) {
        Preco = preco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getComposicao() {
        return Composicao;
    }

    public void setComposicao(String composicao) {
        Composicao = composicao;
    }

}
