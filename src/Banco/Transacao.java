import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private String tipo;
    private double valor;
    private LocalDateTime data;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDataString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }
}
