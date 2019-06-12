import javax.swing.*;
import java.util.*;

class Main{
    public static void main(String args[]) {
        // link importante sobre o JOptionPane: https://www.mkyong.com/swing/java-swing-joptionpane-showoptiondialog-example/
        String nome, endereco, telefone, email, documento, opc;
        List<Cliente> ListaClientes = new ArrayList<>(); // fazendo a lista de clientes
        String[] opcoes = {"Pessoa Física", "Pessoa Jurídica"};

        // Cadastro de clientes
        while (true) {
            // Coletando informações
            nome = JOptionPane.showInputDialog(null, "Nome:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);
            endereco = JOptionPane.showInputDialog(null, "Endereço:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);
            telefone = JOptionPane.showInputDialog(null, "Telefone:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);
            email = JOptionPane.showInputDialog(null, "Email:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);
            int tipo_cliente = JOptionPane.showOptionDialog(null, "Selecione o tipo de cliente: ",
                                "Cadastrando clientes",
                                JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Pessoa física
            if(tipo_cliente == 0) {
                documento = JOptionPane.showInputDialog(null, "Digite o CPF: ", "Cadastrando cliente", JOptionPane.QUESTION_MESSAGE);
                ClienteFisico cliente = new ClienteFisico(nome, endereco, telefone, email, documento);
                ListaClientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro completado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                documento = JOptionPane.showInputDialog(null, "Digite o CNPJ: ", "Cadastrando cliente", JOptionPane.QUESTION_MESSAGE);
                ClienteJuridico cliente = new ClienteJuridico(nome, endereco, telefone, email, documento);
                ListaClientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro completado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }

            opc = JOptionPane.showInputDialog(null, "Deseja cadastrar mais um cliente [Ss/Nn]:");
            if(opc.charAt(0) == 'N' || opc.charAt(0) == 'n')
                break; // finalizar o while caso o cliente não queira cadastrar mais clientes
        }

        // exibindo clientes
    }
}