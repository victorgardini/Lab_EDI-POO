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
            // Coletando Informações
            nome = JOptionPane.showInputDialog(null, "Nome:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);
            endereco = JOptionPane.showInputDialog(null, "Endereço:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);
            telefone = JOptionPane.showInputDialog(null, "Telefone:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);
            email = JOptionPane.showInputDialog(null, "Email:", "Cadastrando clientes", JOptionPane.QUESTION_MESSAGE);

            int tipo_cliente = JOptionPane.showOptionDialog(null, "Selecione o tipo de cliente: ",
                                "Cadastrando clientes",
                                JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Cadastrando Pessoa Física
            if(tipo_cliente == 0) {
                documento = JOptionPane.showInputDialog(null, "Digite o CPF: ", "Cadastrando cliente", JOptionPane.QUESTION_MESSAGE);
                ClienteFisico cliente = new ClienteFisico(nome, endereco, telefone, email, documento);
                ListaClientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro completado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
            // Cadastrando Pessoa Jurídica
            else {
                documento = JOptionPane.showInputDialog(null, "Digite o CNPJ: ", "Cadastrando cliente", JOptionPane.QUESTION_MESSAGE);
                ClienteJuridico cliente = new ClienteJuridico(nome, endereco, telefone, email, documento);
                ListaClientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro completado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }

            // finalizar o while caso não queira cadastrar mais clientes
            opc = JOptionPane.showInputDialog(null, "Deseja cadastrar mais um cliente [Ss/Nn]:");
            if(opc.charAt(0) == 'N' || opc.charAt(0) == 'n')
                break; 
        }

        // Exibindo Clientes
        for(int i = 0; i < ListaClientes.size(); i++){
            JOptionPane.showMessageDialog(null, "\n\nTipo: " + ListaClientes.get(i).getTipoCliente() + 
                                                  "\nNome: " + ListaClientes.get(i).getNome() +
                                                  "\nDocumento: " + ListaClientes.get(i).getDocumento(),
                                                  "Exibindo clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}