import java.util.ArrayList;

public class Cliente extends Pessoa{
    Credito credito = new Credito(0, 0,0);
    Debito debito = new Debito(0);
    ArrayList<Produto> carrinho = new ArrayList<>();
    public Cliente(String senha) {
        super(senha);
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public void setDebito(Debito debito) {
        this.debito = debito;
    }

    @Override
    public String menu() {
        return """
                [1]Adicionar Produto ao Carrinho
                [2]Ver Carrinho
                [3]Pagar
                [0]Sair""";
    }
}
