public class Aluno {
    private String nome;
    private int ra; // número da matrícula
    private int idade;
    private String sexo;
    private String cidade_de_nascimento;
    private int ano_ingresso; // ano de ingresso

    // nota do aluno
    private float p1;
    private float p2;

    // Método construtor
    public Aluno(String nome, int ra, int idade, String sexo, String cidade_de_nascimento, int ano_ingresso, float p1, float p2){
        this.nome = nome;
        this.ra = ra;
        this.idade = idade;
        this.sexo = sexo;
        this.cidade_de_nascimento = cidade_de_nascimento;
        this.ano_ingresso = ano_ingresso;
        this.p1 = p1;
        this.p2 = p2;
    }

    // Destacando e implementando os principais métodos (principalmente os gets)
    public String get_nome () {
        return nome;
    }

    public int get_ra() {
        return ra;
    }

    public int get_idade() {
        return idade;
    }

    public String get_sexo() {
        return sexo;
    }

    public String get_cidade_de_nascimento() {
        return cidade_de_nascimento;
    }

    public int get_ano_ingreso() {
        return ano_ingresso;
    }

    public float get_media_aluno(){
        return (p1 + p2) / 2;
    }
}