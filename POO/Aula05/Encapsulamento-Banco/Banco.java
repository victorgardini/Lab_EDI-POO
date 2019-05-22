import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Banco{
    public static void main(String args[]){
        JOptionPane.showMessageDialog(null, "Bem vindo ao Banco(a) Vitim", "Bem vindo(a)", JOptionPane.INFORMATION_MESSAGE);

        // declarando a array cliente e outras variáveis
        List<Cliente> ListaClientes = new ArrayList<>();

        // opções: Cadastrar cliente, selecionar cliente -> consultar saldo, depositar
        // https://www.devmedia.com.br/explorando-a-classe-arraylist-no-java/24298

        try {
            // Cadastro de clientes
            while(true) {
                // Variáveis locais ao cadastro do cliente
                Cliente cliente;
                String resposta = new String(), nome, cpf, rg, endereco;
                int telefone, num_agencia, num_conta = 1;

                nome = JOptionPane.showInputDialog(null, "Digite o seu nome", "Nome:", JOptionPane.QUESTION_MESSAGE);
                cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF", "CPF:", JOptionPane.QUESTION_MESSAGE);
                rg = JOptionPane.showInputDialog(null, "Digite o seu RG:", "RG:", JOptionPane.QUESTION_MESSAGE);
                endereco = JOptionPane.showInputDialog(null, "Digite o seu endereço: ", "Endereço:", JOptionPane.QUESTION_MESSAGE);
                telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o seu telefone", "Tel:", JOptionPane.QUESTION_MESSAGE));

                // Instanciando o objeto cliente
                cliente = new Cliente(nome, cpf, rg, endereco, telefone);


                num_agencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a agência que deseja cadastrar", "Agência:", JOptionPane.QUESTION_MESSAGE));
                // num_conta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o seu telefone", "Tel:"));
                
                // abrindo a conta do cliente
                cliente.abrirConta(num_agencia, num_conta);
                num_conta++; // contadora de contas & controladora do num conta nesta agência

                resposta = JOptionPane.showInputDialog(null, "Deseja depositar algum valor [S/N]:");
                if(resposta.charAt(0) == 'S' || resposta.charAt(0) == 's'){
                    double deposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual quantia você deseja depositar: ", "Depósito:", JOptionPane.QUESTION_MESSAGE));
                    cliente.setSaldo(deposito);
                }

                // Adicionando este cliente a lista de clientes
                ListaClientes.add(cliente);

                // Verificando se o usuário deseja cadastrar mais contas
                resposta = JOptionPane.showInputDialog(null, "Deseja cadastrar mais algum usuário [S/N]:");
                if(resposta.charAt(0) == 'N' || resposta.charAt(0) == 'n')
                    break;
            }

            // Listagem de clientes
            for(int i=0; i < ListaClientes.size(); i++){
                // exibindo cliente
                ListaClientes.get(i).getExtrato();
            }
        }
        catch(Exception e) {
            e.getMessage();
        }
    }    
}