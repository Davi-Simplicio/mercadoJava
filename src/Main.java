import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Pessoa usuarioLogado;
    static Cliente cliente = new Cliente("123");
    static Funcionario funcionario = new Funcionario("321");
    static Caixa caixa = new Caixa(0, 0);
    static int dia = 0;

    public static void main(String[] args) {
        Pessoa.pessoas.add(funcionario);
        Pessoa.pessoas.add(cliente);
        do {
            login();
        }while (true);
    }

    public static void login() {
        System.out.println("Digite sua senha");
        String senha = sc.next();
        usuarioLogado = Pessoa.procurarPessoa(senha);
        menu();

    }

    private static void menu() {
        int opcao = 0;
        do {
            System.out.println(usuarioLogado.menu());
            opcao = sc.nextInt();
            if (usuarioLogado instanceof Cliente) {
                switchCaseCliente(opcao);
            } else {
                switchCaseFuncionario(opcao);
            }
        } while (opcao != 0);
    }

    private static void switchCaseFuncionario(int opcao) {
        switch (opcao) {
            case 1:
                adicionarProduto();
                break;
            case 2:
                break;
        }
    }

    private static void adicionarProduto() {
        System.out.println("Qual produto você deseja adicionar?\n" + """
                [1]Chocolate
                [2]Escova de Dentes
                [3]Cereal""");
        int opcao = sc.nextInt();
        System.out.println("Qual o nome do Produto");
        String nome = sc.next();
        switch (opcao) {
            case 1:
                Chocolate chocolate = new Chocolate(20.00, "Alimentos", Produto.getPrudutos().size(), nome);
                chocolate.adicionar();
                break;
            case 2:
                EscovaDeDentes escovaDeDentes = new EscovaDeDentes(10.00, "Higiene", Produto.getPrudutos().size(), nome);
                escovaDeDentes.adicionar();
                break;
            case 3:
                Cereal cereal = new Cereal(40.00, "Alimentos", Produto.getPrudutos().size(), nome);
                cereal.adicionar();
                break;
        }
    }

    private static void switchCaseCliente(int opcao) {
        switch (opcao) {
            case 1:
                adiconarProdutoAoCarrinho();
                break;
            case 2:
                verCarrinho();
                break;
            case 3:
                pagar();
                break;
            case 4:
                break;
        }
    }

    private static void adiconarProdutoAoCarrinho() {
        System.out.println("Qual produto você deseja?");
        System.out.println(Produto.getPrudutos());
        int opcao = sc.nextInt();
        if (Produto.getPrudutos().get(opcao) != null) {
            ((Cliente) usuarioLogado).carrinho.add(Produto.getPrudutos().get(opcao));
            Produto.getPrudutos().get(opcao).remover();
        }
    }

    private static void verCarrinho() {
        System.out.println(((Cliente)usuarioLogado).carrinho);
    }

    private static void pagar() {
        double valor = defineValor();
        System.out.println("Qual Forma de Pagamento?");
        System.out.println("""
                [1]Débito
                [2]Crédito""");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                debito(valor);
                break;
            case 2:
                credito(valor);
        }
        ((Cliente)usuarioLogado).carrinho.removeAll(itensRemovidos());
        passarDia();
    }

    private static ArrayList<Produto> itensRemovidos() {
        return ((Cliente)usuarioLogado).carrinho;
    }

    private static double defineValor() {
        double valor = 0;
        for (Produto produtoE : ((Cliente) usuarioLogado).carrinho) {
            valor += produtoE.getPreco();
        }
        return valor;
    }

    private static void credito(double valor) {
        System.out.println("Em quantas parcelas será pago?");
        int parcelas = sc.nextInt();
        Credito credito = new Credito(parcelas, defineValor() * 0.02, valor / parcelas);
        ((Cliente) usuarioLogado).setCredito(credito);
        caixa.setQuantidadeDeClientes(caixa.getQuantidadeDeClientes() + 1);
    }

    private static void debito(double valor) {
        Debito debito = new Debito(valor * 0.05);
        ((Cliente) usuarioLogado).setDebito(debito);
        caixa.setQuantidadeDeDinheiro(caixa.getQuantidadeDeDinheiro() + (valor - debito.desconto));
        caixa.setQuantidadeDeClientes(caixa.getQuantidadeDeClientes() + 1);
    }

    public static void passarDia() {
        if (Produto.getPrudutos().size()== 0) {
            System.out.println("Dia: " + dia + "\n" + caixa.gerarRecibo());
            dia++;
            for (Pessoa pessoaE : Pessoa.pessoas) {
                if (pessoaE instanceof Cliente) {
                    if (((Cliente) pessoaE).getCredito().getParcelas() > 0) {
                        caixa.setQuantidadeDeDinheiro(caixa.getQuantidadeDeDinheiro() + (((Cliente) pessoaE).getCredito().getValor()));
                        ((Cliente) pessoaE).getCredito().setParcelas(((Cliente) pessoaE).getCredito().getParcelas() - 1);
                    }
                }
            }
        }
    }
}
