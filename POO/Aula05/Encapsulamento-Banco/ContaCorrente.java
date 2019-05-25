public class ContaCorrente {
    private int num_agencia;
    private int num_conta;
    private double saldo;

    // Construtor conta corrente
    public ContaCorrente(int num_agencia, int num_conta) {
        this.num_agencia = num_agencia;
        this.num_conta = num_conta;
        saldo = 0;
    }

    public int getNumAgencia() {
        return num_agencia;
    }

    public int getNumConta() {
        return num_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    // setSaldo -> Depósito
    public void depositar(double deposito) {
        if (deposito > 0)
            saldo += deposito;
        else {
            // forçando uma exceção
            throw new ArithmeticException();
        }
    }

    // setSaldo -> Saque
    public void sacar(double saque) {
        if (saque > 0 && (saldo - saque >= 0))
            saldo -= saque;
        else {
            // forçando uma exceção
            throw new ArithmeticException();
        }
    }
}