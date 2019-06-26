public class Professor extends Pessoa {
    private String registro_professor;
    private String disciplina_ministrada;
    private double salario;

    public Professor(String nome, int idade, String endereco, String telefone, String email, String cpf, String registro_professor, String disciplina_ministrada, double salario){
        super(nome, idade, endereco, telefone, email, cpf);
        this.registro_professor = registro_professor;
        this.disciplina_ministrada = disciplina_ministrada;
       	this.salario = salario;
    }

    public String toString(){
        return "PROFESSOR\n\nNome: " + getNome() + "\nID: " + criarID() + "\nIdade: " + getIdade() + "\nEndereço: " + getEndereco() 
        + "\nTelefone: " + getTelefone() + "\nE-mail: " + getEmail() + "\nCPF: " + getCpf() + "\nRegistro do Professor (RP): " + registro_professor
        + "\nDisciplina Ministrada: " + disciplina_ministrada + "\nSalário: " + salario;
    }

    public String getDisciplina(){
        return disciplina_ministrada;
    }

    public String criarID(){
        int n = (int) Math.random() * (999 - 100) + 999;
                   // Math.random() * (max - min) + min
        return "DCCE, " + getDisciplina() + n;
    }
}