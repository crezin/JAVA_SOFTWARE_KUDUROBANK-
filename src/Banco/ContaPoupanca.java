public class ContaPoupanca extends Conta {
    private static final double JUROS_ANUAIS = 0.05;

    public ContaPoupanca(String numero) {
        super(numero);
    }

    public void aplicarJuros() {
        double juros = getSaldo() * JUROS_ANUAIS;
        depositar(juros);
    }
}
