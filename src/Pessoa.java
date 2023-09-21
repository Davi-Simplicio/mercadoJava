import java.util.ArrayList;

public abstract class Pessoa {
    String senha;
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Pessoa(String senha) {
        this.senha = senha;
    }

    public abstract String menu();

    public static Pessoa procurarPessoa(String senha) {
        for (Pessoa pessoaE : pessoas) {
            if (senha.equals(pessoaE.senha)) {
                return pessoaE;
            }
        }
        return null;
    }
}
