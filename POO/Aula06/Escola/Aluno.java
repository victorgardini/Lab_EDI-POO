import javax.swing.JOptionPane;

public class Aluno extends Pessoa {
    private String ra;
    private String curso;

    public Aluno(String nome, int idade, String endereco, String telefone, String email, String cpf, String ra, String curso) {
        super(nome, idade, endereco, telefone, email, cpf);
        this.ra = ra;
        this.curso = curso;
    }

    public String toString() {
        return "ALUNO\n\nNome: " + getNome() + "\nID: " + criarID() + "\nIdade: " + getIdade() + "\nEndereço: " + getEndereco() + "\nTelefone: " + getTelefone()
        + "\nE-mail: " + getEmail() + "\nCPF: " + getCpf() + "\nRegistro do Aluno (RA): " + ra + "\nCurso: " + curso;
    }

    public String criarID(){
        String cp_cpf = getCpf();
        return cp_cpf.charAt(0) + cp_cpf.charAt(1) + cp_cpf.charAt(2) + "." + cp_cpf.charAt(3) + cp_cpf.charAt(4) + cp_cpf.charAt(5) + "." + cp_cpf.charAt(6) + cp_cpf.charAt(7) + cp_cpf.charAt(8) + "-" + cp_cpf.charAt(9) + cp_cpf.charAt(10);
    }
}