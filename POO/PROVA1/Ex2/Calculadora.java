import java.util.*;

class Calculadora {
    public static void main(String args[]) {
        Scanner dado = new Scanner(System.in);

        // Solicitando a entrada de três números
        float n1, n2, n3;
        int opc;

        System.out.println("\n\n>>> Bem vindo(a) a Calculadora nota Dez:");

        // Lendo números
        System.out.print("   > Digite o primeiro número: ");
        n1 = dado.nextFloat();
        
        System.out.print("   > Digite o segundo número: ");
        n2 = dado.nextFloat();
        
        System.out.print("   > Digite o terceiro número: ");
        n3 = dado.nextFloat();

        //  escolhendo a opção
        System.out.print("\n>>> O que deseja fazer com esses três números:\n     1. Somar\n     1. Subtrair\n     3. Multiplicar \n     4. Dividir\n> Opção: ");
        opc = dado.nextInt();
        System.out.println("\n");
        switch(opc){
            case 1: // somar
                // criando um obj para somar
                Adicao adicao = new Adicao();
                adicao.somar(n1, n2, n3);
            break;
            case 2: // subtrair
                // criando um obj para subtrair
                Subtracao subtracao = new Subtracao();
                subtracao.subtrair(n1, n2, n3);
            break;
            case 3: // multiplicar
                // criando um obj para multiplicar
                Multiplicacao multiplicacao = new Multiplicacao();
                multiplicacao.multiplicar(n1, n2, n3);
            break;
            case 4: // dividir
                // criando um obj para subtrair
                Divisao divisao = new Divisao();
                try{
                    divisao.dividir(n1, n2, n3);
                }
                catch (Exception e) {
                    System.out.println("ERRO! algum valor que você digitou, gerou uma divisão por 0. Por favor, tente novamente.");
                }
            break;
            default: System.out.println("Opção inválida!");            
        }
        System.out.println("\n");
    }
}