public class FuncionarioHorista extends Funcionario {
    private int quant_horas; // quantidade de horas trabalhadas
    private int pagamento_hora = 175;

    public FuncionarioHorista(String nome, String sobrenome, int quant_horas){
        super(nome, sobrenome);
        this.quant_horas = quant_horas;
    }

    private void calculaSalario() {
        salario = quant_horas *pagamento_hora;
    }

    public double getSalario(){
        calculaSalario();
        return salario;
    }

    public int getQuantidade(){
        return quant_horas;
    }

    public String tipoFuncionario(){
        return "Horista";
    }
}