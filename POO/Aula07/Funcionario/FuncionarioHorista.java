public class FuncionarioHorista extends Funcionario{
    private int quant_horas; // quantidade de horas trabalhadas
    private int pagamento_hora = 175;

    public FuncionarioHorista(String nome, String sobrenome, double salario, int quant_horas){
        super(nome, sobrenome, salario);
        this.quant_horas = quant_horas;
    }

    public double getSalario(){
        return quant_horas * pagamento_hora;
    }
}