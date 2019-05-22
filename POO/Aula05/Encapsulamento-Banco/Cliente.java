import javax.swing.*;

public class Cliente {
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private int telefone;
    private ContaCorrente conta_corrente;

    public Cliente(String nome, String cpf, String rg, String endereco, int telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getRG() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    // Método referente a abertura de uma conta corrente
    public void abrirConta(int num_agencia, int num_conta) {
        conta_corrente = new ContaCorrente(num_agencia, num_conta);
    }

    public double getSaldo(){
        return conta_corrente.getSaldo();
    }

    public void setSaldo(double novo_saldo){
        if(novo_saldo > 0){
            conta_corrente.depositar(novo_saldo);
        }
    }

    public void getExtrato(){
        JOptionPane.showMessageDialog(null, "Exibindo informaçoẽs do cliente:\n" +
        "Nome: " + nome + "\n" +
        "CPF: " + cpf + "\n" +
        "RG: " + rg + "\n" +
        "Endereço: " + endereco + "\n" +
        "Telefone: " + telefone + "\n" +
        "Agencia: " + conta_corrente.getNumAgencia() + "\n" +
        "Numero Conta: " + conta_corrente.getNumConta() + "\n" +
        "Saldo: " + conta_corrente.getSaldo() + "\n", "Exibindo informações do cliente", JOptionPane.INFORMATION_MESSAGE);
    }
}