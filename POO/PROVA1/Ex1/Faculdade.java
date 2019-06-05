import java.util.*;

class Faculdade {
    public static void main(String args[]) {
        // Variáveis que auxiliam o cadastro da disciplina
        String nome_disciplina, nome_professor;
        int id;

        // Variáveis que auxiliam o cadastro do aluno
        String nome, sexo, cidade_de_nascimento;
        int ra, idade, ano_ingresso; // ano de ingresso
        float p1, p2;

        // variavel que armazenará uma disciplina e os respectivos alunos que fazem a mesma
        Disciplina disciplina;
        Aluno aluno;
        Scanner dado = new Scanner(System.in);
        String resposta;

        System.out.println("\n\n-- >>> Bem vindo à faculdade nota Dez: <<< --");

        // Cadastro da disciplina:
        System.out.print("Cadastro de disciplina:\n--> Digite o nome da disciplina: ");
        nome_disciplina = dado.nextLine(); // String
        System.out.print("--> Digite o ID da disciplina: ");
        id = dado.nextInt();               // int
        System.out.print("--> Digite o nome do(a) professor(a): ");
        dado = new Scanner(System.in);
        nome_professor = dado.nextLine();  // String

        // Instanciando o obj disciplina
        disciplina = new Disciplina(nome_disciplina, id, nome_professor);

        // Cadastrando alunos
        for(int i = 0; i < 35; i++){
            System.out.println("\n\n >>> Cadastro de aluno:");
            
            dado = new Scanner(System.in); // limpando o buffer
            System.out.print("   --> Digite o nome: ");
            nome = dado.nextLine();

            System.out.print("   --> Digite o ra: ");
            ra = dado.nextInt();;
            System.out.print("   --> Digite a idade: ");
            idade = dado.nextInt();
            System.out.print("   --> Digite o sexo: ");
            
            dado = new Scanner(System.in);
            sexo = dado.nextLine();;
            System.out.print("   --> Digite a cidade de nascimento: ");
            cidade_de_nascimento = dado.nextLine();;
            System.out.print("   --> Digite o ano de ingresso: ");
            ano_ingresso = dado.nextInt();
            System.out.print("   --> Digite a nota da p1: ");
            p1 = dado.nextInt();
            System.out.print("   --> Digite a nota da p2: ");
            p2 = dado.nextInt();

            // criando um novo obj aluno
            aluno = new Aluno(nome, ra, idade, sexo, cidade_de_nascimento, ano_ingresso, p1, p2);

            // adicionando este aluno na disciplina
            disciplina.cadastrar_aluno(aluno);

            // Se não quiser cadastrar mais alunos, encerra o loop
            System.out.println("Deseja cadastrar mais algum usuário [S/N]:");
            dado = new Scanner(System.in);
            resposta = dado.nextLine();
            if (resposta.charAt(0) == 'N' || resposta.charAt(0) == 'n')
                break;
        }


        System.out.println("\n\n >>> Exibindo estado atual da disciplina " + disciplina.get_nome() + ":");
        // Exibindo a situação de todos os alunos na disciplina
        disciplina.get_estado_alunos();
    }
}