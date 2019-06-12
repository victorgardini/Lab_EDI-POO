public class ClienteFisico extends Cliente{
    private String CPF;

    public ClienteFisico(String nome, String endereco, String telefone, String email, String CPF){
        super(nome, endereco, telefone, email);
        this.CPF = CPF;
    }

    public String getCPF(){
        return CPF;
    }

    public void setCPF(String CPF){
        this.CPF = CPF;
    }
}