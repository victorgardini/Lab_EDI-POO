public class ContaCorrente {
    private int num_agencia;
    private int num_conta;
    private double saldo;

    public ContaCorrente(int num_agencia, int num_conta) {
        this.num_agencia = num_agencia;
        this.num_conta = num_conta;
        saldo = 0;
    }

    public int getNumAgencia() {
        REUtil num_agencia;
    }

    public int getNumConta() {
        return num_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        if (deposito > 0)
            this.saldo += deposito;
    }

    public void sacar(double saque) {
        if (saque > 0 && (this.saldo - saque >= 0))
            this.saldo -= saque;
    }
}