public abstract class Pessoa {
    private String nome;
    private int idade;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    public Pessoa(String nome, int idade, String endereco, String telefone, String email, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
    	return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
    	return cpf;
    }

    public abstract String toString();
    public abstract String criarID();
}