import java.util.*;

public class Pessoa {
    public static void main(String Args[]) {
        Scanner dado = new Scanner(System.in);

        try {
            System.out.println("--> Quanto você andou hoje [km]: ");
            double km = dado.nextDouble();
            km *= 1000;

            System.out.println("--> Quanl é o tamanho do seu passo [m]: ");
            double tam_passos = dado.nextDouble();

            PessoaCorredor pessoa01 = new PessoaCorredor(km, tam_passos);
            System.out.println("--> Você deu " + pessoa01.getQuantidade_passos() + " passos");

        } catch (NumberFormatException e) {
            System.out.println("--> Por favor, digite apenas números!");
        }
    }
}
