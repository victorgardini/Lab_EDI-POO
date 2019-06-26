public class Mamifero extends Animal{
    private String cor_pelo;

    public Mamifero(double peso, int idade, int membros, String cor_pelo) {
        super(peso, idade, membros);
        this.cor_pelo = cor_pelo;
    }

    public String locomover(){
        return "Locomover de Mamifero";
    }

    public String alimentar(){
        return "Alimentar de Mamifero";
    }

    public String emitirSom(){
        return "Som de mamífero";
    }
}