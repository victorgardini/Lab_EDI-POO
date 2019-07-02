public class FuncionarioComissionado extends Funcionario {
    private int quant_vendas;
    private int pagamento_venda = 72;

    public FuncionarioComissionado(String nome, String sobrenome, int quant_vendas){
        super(nome, sobrenome);
        this.quant_vendas = quant_vendas;
    }

    private void calculaSalario(){
        salario = quant_vendas * pagamento_venda;
    }

    public double getSalario(){
        calculaSalario();
        return salario;
    }

    public int getQuantidade(){
        return quant_vendas;
    }

    public String tipoFuncionario(){
        return "Comissionado";
    }
}