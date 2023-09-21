public class Credito extends FormaDePagamento{
    private int parcelas;
    private double juros;
    private double valor;

    public Credito(int parcelas, double juros,double valor) {
        this.parcelas = parcelas;
        this.juros = juros;
        this.valor = valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public double getValor() {
        return valor;
    }

    public double getJuros() {
        return juros;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
