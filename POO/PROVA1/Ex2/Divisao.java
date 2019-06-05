public class Divisao {

    public void dividir(float n1, float n2, float n3){
        // validando a divisão por 0
        if(n2 == 0)
            throw new ArithmeticException("Divisão por 0: Inválida!");
        else {
            float res = (n1 + n2) + n3;
            System.out.println(">>> Resultado: ("+ n1 +" / "+ n2 +") / "+ n3 +" = " + res);
        }
    }
}