import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String args[]) {
        // Lista de pessoas
        List<Pessoa> pessoas = new ArrayList<>();
        String[] options = {"Aluno", "Professor"};

        // JOptionPane.showMessageDialog(null, "Cadastrando ALUNO/PROFESSOR...", "ESCOLA", JOptionPane.INFORMATION_MESSAGE);

        try{
            while(true){
                // Recebendo qual tipo deseja registrar
                int tipo = JOptionPane.showOptionDialog(null, "Qual opção deseja cadastrar?", "ESCOLA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                // Adicionando informações
                String nome = JOptionPane.showInputDialog(null, "Nome: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Idade: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE));
                String endereco = JOptionPane.showInputDialog(null, "Endereço: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                String telefone = JOptionPane.showInputDialog(null, "Telefone: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                String email = JOptionPane.showInputDialog(null, "E-mail: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                String cpf = JOptionPane.showInputDialog(null, "CPF: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);

                switch(tipo){
                    // Aluno
                    case 0:
                        String ra = JOptionPane.showInputDialog(null, "Registro do Aluno (RA): ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                        String curso = JOptionPane.showInputDialog(null, "Curso: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                        // Instaciando o objeto aluno do tipo Aluno
                        Aluno aluno = new Aluno(nome, idade, endereco, telefone, email, cpf, ra, curso);
                        // Adicionando o objeto aluno na lista pessoas
                        pessoas.add(aluno);
                        break;
                    // Professor
                    case 1:
                        String rp = JOptionPane.showInputDialog(null, "Registro do Professor (RP): ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                        String disciplina_ministrada = JOptionPane.showInputDialog(null, "Disciplina Ministrada: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE);
                        double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário: ", "ESCOLA", JOptionPane.QUESTION_MESSAGE));
                        // Instaciando o objeto professor do tipo Professor
                        Professor professor = new Professor(nome, idade, endereco, telefone, email, cpf, rp, disciplina_ministrada, salario);
                        // Adicionando o objeto professor na lista pessoas
                        pessoas.add(professor);
                        break;
                }

                // Verifica se o usuário deseja inserir mais ou não
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar inserindo?", "ESCOLA", JOptionPane.YES_NO_OPTION);
                if(opcao == 1)
                    break;
            }

            JOptionPane.showMessageDialog(null, "Exibindo os dados cadastrados!", "ESCOLA", JOptionPane.INFORMATION_MESSAGE);
            for(int i = 0; i < pessoas.size(); i++) {
                JOptionPane.showMessageDialog(null, pessoas.get(i).toString(), "ESCOLA", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(null, "Digite apenas números", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
}