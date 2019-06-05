import java.util.*;

public class Disciplina {
    private String nome_disciplina;
    private int id;
    private String nome_professor;
    private List<Aluno> ListaAlunos = new ArrayList<>(); // declarando a lista de alunos contidos nesta disciplina (e respectivamente, as duas notas)

    // Método construtor da classe disciplina
    public Disciplina(String nome_disciplina, int id, String nome_professor) {
        this.nome_disciplina = nome_disciplina;
        this.id = id;
        this.nome_professor = nome_professor;
    }

    public void cadastrar_aluno(Aluno aluno){
        ListaAlunos.add(aluno); // adicionando o objeto na lista
    }

    public String get_nome(){
        return nome_disciplina;
    }

    // Este método exibe na tela o estado de todos os alunos cadastrados
    public void get_estado_alunos() {
        // buscando o aluno na lista de alunos
        for(int i = 0; i < ListaAlunos.size(); i++){
            if(ListaAlunos.get(i).get_media_aluno() >= 5)
                System.out.println("   >>> O Aluno " + ListaAlunos.get(i).get_nome() + ", RA: " + ListaAlunos.get(i).get_ra() + ", está APROVADO!");
            else if(ListaAlunos.get(i).get_media_aluno() >= 3)
                System.out.println("   >>> O Aluno " + ListaAlunos.get(i).get_nome() + ", RA: " + ListaAlunos.get(i).get_ra() + ", está de EXAME!");
            else
                System.out.println("   >>> O Aluno " + ListaAlunos.get(i).get_nome() + ", RA: " + ListaAlunos.get(i).get_ra() + ", está REPROVADO!");
        }
    }
    
}