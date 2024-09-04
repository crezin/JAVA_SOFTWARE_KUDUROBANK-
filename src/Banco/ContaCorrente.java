public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero) {
        super(numero);
        this.limite = 500.0; // Exemplo de limite
    }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo() + limite) {
            super.sacar(valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente e limite excedido.");
        }
    }
}
