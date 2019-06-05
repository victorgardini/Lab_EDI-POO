import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Banco {
    public static void main(String args[]) {
        JOptionPane.showMessageDialog(null, "Bem vindo ao Banco Victor", "Bem vindo(a)", JOptionPane.INFORMATION_MESSAGE);

        // declarando a lista cliente
        List<Cliente> ListaClientes = new ArrayList<>();

        try {
            // Cadastro de clientes
            while (true) {
                // Variáveis locais ao cadastro do cliente
                Cliente cliente; // instanciando uma variável do tipo cliente
                String resposta = new String(), nome, cpf, rg, endereco;
                int telefone, num_agencia, num_conta = 1;

                // Recebendo od dados do cliente
                nome = JOptionPane.showInputDialog(null, "Digite o seu nome", "Nome:", JOptionPane.QUESTION_MESSAGE);
                cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF", "CPF:", JOptionPane.QUESTION_MESSAGE);
                rg = JOptionPane.showInputDialog(null, "Digite o seu RG:", "RG:", JOptionPane.QUESTION_MESSAGE);
                endereco = JOptionPane.showInputDialog(null, "Digite o seu endereço: ", "Endereço:",
                        JOptionPane.QUESTION_MESSAGE);
                telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o seu telefone", "Tel:",
                        JOptionPane.QUESTION_MESSAGE));

                // Instanciando um novo objeto cliente
                cliente = new Cliente(nome, cpf, rg, endereco, telefone);

                // Recebendo os dados da conta do cliente
                num_agencia = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Digite a agência que deseja cadastrar", "Agência:", JOptionPane.QUESTION_MESSAGE));
                // num_conta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o seu
                // telefone", "Tel:"));

                // abrindo a conta do cliente
                cliente.abrirConta(num_agencia, num_conta);
                num_conta++; // contadora de contas & controladora do num conta nesta agência

                // Sair da repetição infinita (while true)
                resposta = JOptionPane.showInputDialog(null, "Deseja depositar algum valor [S/N]:");
                if (resposta.charAt(0) == 'S' || resposta.charAt(0) == 's') {
                    double deposito = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Qual quantia você deseja depositar: ", "Depósito:", JOptionPane.QUESTION_MESSAGE));
                    cliente.setSaldo(deposito);
                }

                // Adicionando este cliente a lista de clientes
                ListaClientes.add(cliente);

                // Verificando se o usuário deseja cadastrar mais contas
                resposta = JOptionPane.showInputDialog(null, "Deseja cadastrar mais algum usuário [S/N]:");
                if (resposta.charAt(0) == 'N' || resposta.charAt(0) == 'n')
                    break;
            }

            // Listagem de clientes
            for (int i = 0; i < ListaClientes.size(); i++) {
                // exibindo cliente
                ListaClientes.get(i).getExtrato();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite entradas válidas!", "Valores inválidos!", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite entradas válidas!", "Valores inválidos!", JOptionPane.ERROR_MESSAGE);
        }
    }
}