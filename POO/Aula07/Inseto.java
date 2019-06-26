public class Inseto extends Animal{
    private int n_antenas;

    public Inseto(double peso, int idade, int membros, int n_antenas) {
        super(peso, idade, membros);
        this.n_antenas = n_antenas;
    }
    
    public int getAntenas(){
        return n_antenas;
    }

    public void setAntenas(int n_antenas){
        this.n_antenas = n_antenas;
    }

    public String locomover(){
        return "Locomoção de Inseto";
    }

    public String alimentar(){
        return "Alimentar de inseto";
    }

    public String emitirSom(){
        return "Som de inseto";
    }
}