public abstract class Funcionario{
    private String nome;
    private String sobrenome;
    private double salario;

    public Funcionario(String nome, String sobrenome, double salario){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
    }

    public String getNome(){
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public abstract double getSalario();
    // public abstract void setSalario();
}