import javax.swing.*;

public class Cliente {
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private int telefone;
    private ContaCorrente conta_corrente;

    // construtor cliente
    public Cliente(String nome, String cpf, String rg, String endereco, int telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // métodos
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

    public double getSaldo() {
        return conta_corrente.getSaldo();
    }

    // setSaldo -> depósito
    public void setSaldo(double novo_saldo) {
        if (novo_saldo > 0) {
            conta_corrente.depositar(novo_saldo);
        } else {
            MensagemErro("Valor de depósito inválido!");
            // forçando uma exceção
            throw new ArithmeticException();
        }
    }

    // Método que levanta uma mensagem de erro préviamente configurada
    private void MensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro: " + mensagem, JOptionPane.ERROR_MESSAGE);
    }

    public void getExtrato() {
        JOptionPane.showMessageDialog(null,
                "Exibindo informaçoẽs do cliente:\n" + "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "RG: " + rg
                        + "\n" + "Endereço: " + endereco + "\n" + "Telefone: " + telefone + "\n" + "Agencia: "
                        + conta_corrente.getNumAgencia() + "\n" + "Numero Conta: " + conta_corrente.getNumConta() + "\n"
                        + "Saldo: " + conta_corrente.getSaldo() + "\n",
                "Exibindo informações do cliente", JOptionPane.INFORMATION_MESSAGE);
    }
}