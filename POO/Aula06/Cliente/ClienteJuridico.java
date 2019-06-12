public class ClienteJuridico extends Cliente{
    private String CNPJ;

    public ClienteJuridico(String nome, String endereco, String telefone, String email, String CNPJ){
        super(nome, endereco, telefone, email);
        this.CNPJ = CNPJ;
    }

    public String getDocumento(){
        return CNPJ;
    }

    public void setDocumento(String documento){
        this.CNPJ = documento;
    }

    public String getTipoCliente(){
        return "Pessoa Jurídica";
    }
}