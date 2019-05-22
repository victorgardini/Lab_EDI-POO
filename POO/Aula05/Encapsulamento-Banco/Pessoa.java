public class Cliente {
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private int telefone;

    public Cliente(String nome, String cpf, String rg, String endereco, int telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getRG() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getTelefone() {
        return telefone;
    }
}