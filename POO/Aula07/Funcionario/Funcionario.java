public abstract class Funcionario{
    private String nome;
    private String sobrenome;
    protected double salario;

    public Funcionario(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome(){
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public abstract double getSalario();
    public abstract String tipoFuncionario();
    public abstract int getQuantidade();
    // public abstract void setSalario();
}