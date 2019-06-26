public class FuncionarioComissionado extends Funcionario {
    private int quant_vendas;
    private int pagamento_venda = 72;

    public FuncionarioComissionado(String nome, String sobrenome, double salario, int quant_vendas){
        super(nome, sobrenome, salario);
        this.quant_vendas = quant_vendas;
    }

    public double getSalario(){
        return quant_vendas * pagamento_venda;
    }
}