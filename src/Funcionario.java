public class Funcionario extends Pessoa{
    public Funcionario(String senha) {
        super(senha);
    }

    @Override
    public String menu() {
        return """
                [1]Adicionar Produto
                [0]Sair""";
    }
}
