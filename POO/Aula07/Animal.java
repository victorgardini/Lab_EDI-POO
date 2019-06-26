public abstract class Animal{
    private double peso;
    private int idade;
    private int membros;

    public Animal(double peso, int idade, int membros){
        this.peso = peso;
        this.idade = idade;
        this.membros = membros;
    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getMembros(){
        return membros;
    }

    public void setMembros(){
        this.membros = membros;
    }

    public abstract String locomover();
    public abstract String alimentar();
    public abstract String emitirSom();
}