import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String senhaHash;
    private Conta conta;

    public Cliente(String cpf, String senha) {
        this.cpf = cpf;
        this.senhaHash = hashSenha(senha);
        this.conta = new ContaCorrente(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public boolean autenticar(String senha) {
        return this.senhaHash.equals(hashSenha(senha));
    }

    public Conta getConta() {
        return conta;
    }

    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao hashear a senha", e);
        }
    }
}
