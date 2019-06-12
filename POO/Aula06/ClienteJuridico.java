public class ClienteJuridico extends Cliente{
    private String CNPJ;

    public ClienteJuridico(String nome, String endereco, String telefone, String email, String CNPJ){
        super(nome, endereco, telefone, email);
        this.CNPJ = CNPJ;
    }

    public String getCNPJ(){
        return CNPJ;
    }

    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }
}