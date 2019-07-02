import java.util.*;

import javax.swing.JOptionPane;

class Main{
    public static void main(String args[]) {
        Funcionario funcionario; // aux
        String nome, sobrenome, resp;
        int aux; // usado tanto para armazenar a quant vendida quanto horas trabalhadas
        List<Funcionario> lista_funcionarios = new ArrayList<>();
        double total_salario = 0; // total de salários de todos do mês
        int tot_prod_comissionado = 0; // total de produtos vendidos por todos so comissionados
        int tot_hora_trabalhadas = 0; // total de horas trabalhadas por todos os funcionários no mês

        // Cadastrando funcionários
        while(true){
            JOptionPane.showMessageDialog(null, "Novo funcionário:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
            nome = JOptionPane.showInputDialog(null, "Nome", "Cadastro", JOptionPane.QUESTION_MESSAGE);
            sobrenome = JOptionPane.showInputDialog(null, "Sobrenome", "Cadastro", JOptionPane.QUESTION_MESSAGE);

            // atributos diferentes
            aux = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Comissionado\n2 - Horista: ", "Tipo de funcionário", JOptionPane.QUESTION_MESSAGE));
            if (aux == 1) { // cadastrar comissionado
                aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos produtos o funcionário vendeu: ", "Quantidade de vendas", JOptionPane.QUESTION_MESSAGE));
                funcionario = new FuncionarioComissionado(nome, sobrenome, aux);

                lista_funcionarios.add(funcionario);
            }
            else { // cadastrar horista
                aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas horas você trabalhou: ", "Quantidade de horas", JOptionPane.QUESTION_MESSAGE));
                funcionario = new FuncionarioHorista(nome, sobrenome, aux);

                lista_funcionarios.add(funcionario);

            }
            resp = JOptionPane.showInputDialog(null, "Deseja cadastrar mais algum funcionário [Ss/Nn]:");
            if(resp.charAt(0) == 'N' || resp.charAt(0) == 'n')
                break;
        }

        // Percorrendo a lista
        for(int i = 0; i < lista_funcionarios.size(); i++){
            // gerar uma folha de pgto. com nome, sobrenome e salário
            JOptionPane.showMessageDialog(null, "Nome: " + lista_funcionarios.get(i).getNome() + 
            "\nSobrenome: " + lista_funcionarios.get(i).getSobrenome() + 
            "\nSalário: R$ " + lista_funcionarios.get(i).getSalario(), "Exibindo funcionário", JOptionPane.INFORMATION_MESSAGE);
            
            total_salario += lista_funcionarios.get(i).getSalario();

            // verificando o tipo de funcionário
            if(lista_funcionarios.get(i).tipoFuncionario().equals("Horista")) // verificando se é funcionário horista
                tot_hora_trabalhadas += lista_funcionarios.get(i).getQuantidade();
            else
                tot_prod_comissionado += lista_funcionarios.get(i).getQuantidade();
        }

        JOptionPane.showMessageDialog(null, "Total de horas trabalhadas (horistas): " + tot_hora_trabalhadas +
        "\nTotal produtos vendidos (comissionados): " + tot_prod_comissionado +
        "\n Total de salários pagos este mês: R$" + total_salario, "Resultados Finais", JOptionPane.INFORMATION_MESSAGE);
    }
}