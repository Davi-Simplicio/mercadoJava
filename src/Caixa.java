public class Caixa implements IReciboDoDia{
    private double quantidadeDeDinheiro;
    private int quantidadeDeClientes;

    public Caixa(double quantidadeDeDinheiro, int quantidadeDeClientes) {
        this.quantidadeDeDinheiro = quantidadeDeDinheiro;
        this.quantidadeDeClientes = quantidadeDeClientes;
    }

    public double getQuantidadeDeDinheiro() {
        return quantidadeDeDinheiro;
    }

    public void setQuantidadeDeDinheiro(double quantidadeDeDinheiro) {
        this.quantidadeDeDinheiro = quantidadeDeDinheiro;
    }

    public int getQuantidadeDeClientes() {
        return quantidadeDeClientes;
    }

    public void setQuantidadeDeClientes(int quantidadeDeClientes) {
        this.quantidadeDeClientes = quantidadeDeClientes;
    }

    @Override
    public String gerarRecibo() {
        return toString();
    }

    @Override
    public String toString() {
        return "Caixa\n"+
                "quantidade De Dinheiro no caixa =" + quantidadeDeDinheiro +"R$"+
                ", quantidade De Clientes =" + quantidadeDeClientes +
                '}';
    }
}
