import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected String cpf;
    protected double saldo;
    protected List<Transacao> transacoes;

    public Conta(String cpf) {
        this.cpf = cpf;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valor;
        transacoes.add(new Transacao("Depósito", valor));
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        transacoes.add(new Transacao("Saque", valor));
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
