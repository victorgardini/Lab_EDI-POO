public class PessoaCorredor {
    private double km_percorridos;
    private double tam_passo; // em metros
    private double quantidade_passos;

    public Corredor(double km_percorridos, double tam_passo) {
        this.km_percorridos = km_percorridos;
        this.tam_passo = tam_passo;
    }

    public void setKm_percorridos(double km_percorridos) {
        this.km_percorridos = km_percorridos;
    }

    public double getKm_percorridos() {
        return km_percorridos;
    }

    public void setTam_Passo(double tam_passo) {
        this.tam_passo = tam_passo;
    }

    public double getTamPasso() {
        return tam_passo;
    }

    public double getQuantidade_passos() {
        return this.km_percorridos / this.tam_passo;
    }
}