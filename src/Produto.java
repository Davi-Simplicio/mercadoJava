import java.util.ArrayList;

public class Produto {
    private double preco;
    private String sessao;
    private int codigo;
    private String nome;
    static ArrayList<Produto>produtos = new ArrayList<>();

    public Produto(double preco, String sessao, int codigo, String nome) {
        this.preco = preco;
        this.sessao = sessao;
        this.codigo = codigo;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void adicionar(){
        produtos.add(this);
    }
    public void remover(){
        produtos.remove(this);
    }

    @Override
    public String toString() {
        return "["+produtos.indexOf(this)+"]" +
                "nome='" + nome + '\'' +
                "preco=" + preco +
                "sessao='" + sessao + '\'' +
                "codigo=" + codigo +
                '}';
    }
    public static ArrayList<Produto> getPrudutos() {
        return produtos;
    }
}
