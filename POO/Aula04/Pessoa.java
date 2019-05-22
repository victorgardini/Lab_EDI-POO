import java.util.*;

public class Pessoa {
    public static void main(String Args[]) {
        Scanner dado = new Scanner(System.in);

        try {
            System.out.print("--> Quanto você andou hoje [km]: ");
            double km = dado.nextDouble();
            km *= 1000;

            System.out.print("--> Quanl é o tamanho do seu passo [m]: ");
            double tam_passos = dado.nextDouble();

            PessoaCorredor pessoa01 = new PessoaCorredor(km, tam_passos);
            System.out.println("--> Você deu, aproximadamente, " + pessoa01.getQuantidade_passos()  +" passos\n");

        } catch (NumberFormatException e) {
            System.out.println("--> Por favor, digite apenas números!");
        }
    }
}
