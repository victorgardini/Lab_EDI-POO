 public class ClienteFisico extends Cliente{
    private String CPF;

    public ClienteFisico(String nome, String endereco, String telefone, String email, String CPF){
        super(nome, endereco, telefone, email);
        this.CPF = CPF;
    }

    public String getDocumento(){
        return CPF;
    }

    public void setDocumento(String documento){
        this.CPF = documento;
    }

    public String getTipoCliente(){
        return "Pessoa Física";
    }
}