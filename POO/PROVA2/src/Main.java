import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String args[]) {
        // lista que armazena os times desafiantes (times que o time usuário irá enfrentar)
        List<Team> opponents_teams = new ArrayList<>();

        // time_usuario é o obj que irá armazenar o time que o usuário irá cadastrar
        Team time_usuario;

        // vetor que armazena as possibilidades da posição de cada jogador em um jogo
        String positions[] = {"Entry Fragger", "Suporte", "Lurker", "Game Leader", "AWPer"};
        int opc;

        // apresentação (primeiro menu)
        JOptionPane.showMessageDialog(null, "Bem vindo ao campeonato das lendas do CS!!!\nAqui você irá encontrar alguns dos melhores times de todos os tempos mas não fique desesperado,\nbasta cadastrar o seu time (o último a ser classificado) e lutar pela premiação de U$$ 10.000 dólares!!!!\nDeseja-mos boa sorte pra você!", "Apresentação do campeonado", JOptionPane.INFORMATION_MESSAGE);

        // primeiramente, o usuário irá cadastrar o seu time
        try {
            // nome, sigla e ano de fundação do time
            String team_name = JOptionPane.showInputDialog(null, "Digite o nome do seu time: ", "Nome do seu time", JOptionPane.QUESTION_MESSAGE);
            String team_short_name = JOptionPane.showInputDialog(null, "Abreviatura: ", "Sigla do seu time", JOptionPane.QUESTION_MESSAGE);
            int team_founded = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano fundação:", "Ano de fundação do seu time", JOptionPane.QUESTION_MESSAGE));

            // Criando o manager
            String manager_name = JOptionPane.showInputDialog(null, "Nome coach:", "Nome coach", JOptionPane.QUESTION_MESSAGE);
            String manager_nickname = JOptionPane.showInputDialog(null, "Apelido coach:", "Apelido coach", JOptionPane.QUESTION_MESSAGE);
            int manager_age = Integer.parseInt(JOptionPane.showInputDialog(null, "Idade:", "Idade do coach", JOptionPane.QUESTION_MESSAGE));
            double manager_salary = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário R$:", "Salário Coach", JOptionPane.QUESTION_MESSAGE));
            Manager auxmanager = new Manager(manager_name, manager_nickname, manager_age, manager_salary); // instanciando o obj coach

            // Formando a lista de jogadores do novo time (name, nickname, age, kd_rating)
            JOptionPane.showMessageDialog(null, "Agora vamos cadastrar os 5 jogadores!!");

            // criando uma nova variável lista de jogadores construtor irá usar
            List<Player> team_players = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                String nome_jogador = JOptionPane.showInputDialog(null, "Nome: ", "Nome do " + (i + 1) + " jogador", JOptionPane.QUESTION_MESSAGE);
                String nickname_jogador = JOptionPane.showInputDialog(null, "Nickname: ", "Nickname do " + (i + 1) + " jogador", JOptionPane.QUESTION_MESSAGE);
                int age_jogador = Integer.parseInt(JOptionPane.showInputDialog(null, "Idade: ", "Idade do " + (i + 1) + " jogador: ", JOptionPane.QUESTION_MESSAGE));
                String position_jogador = (String) JOptionPane.showInputDialog(null, "Posição do jogador: ", "Posição do jogador " + (i + 1) + " no jogo", JOptionPane.QUESTION_MESSAGE, null, positions, positions[0]);
                double salary_jogador = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário do jogador: R$", "Salário do jogador", JOptionPane.QUESTION_MESSAGE));

                // Criando o obj
                Player jogador = new Player(nome_jogador, nickname_jogador, age_jogador, position_jogador, salary_jogador);
                team_players.add(jogador); // salvando o obj na lista
            }

            // Instanciando um novo obj time e salvando ele, neste caso, o time é o que o usuário criou
            time_usuario = new Team(team_name, team_short_name, team_founded, auxmanager, team_players);

            // O usuário já criou o seu time, agora, cadastramos 5 outros times (com informações mínimas) que serão armazenados na variável opponents_teams

            // Team(String name, String short_name, int founded, Employee manager, List<Player> formplayers)

            // Cadastrando o oponente 1
            Team aux_team = new Team("MIBR", "MIBR", 2003, null, null);
            opponents_teams.add(aux_team);

            // Cadastrando o oponente 2
            aux_team = new Team("Team Liquid", "Liquid", 2015, null, null);
            opponents_teams.add(aux_team);

            // Cadastrando o oponente 3
            aux_team = new Team("ENCE", "ENCE", 2013, null, null);
            opponents_teams.add(aux_team);

            // Cadastrando o oponente 4
            aux_team = new Team("FURIA eSports", "FURIA", 2017, null, null);
            opponents_teams.add(aux_team);

            // Cadastrando o oponente 5
            aux_team = new Team("Ninjas in Pyjamas", "NIP", 2007, null, null);
            opponents_teams.add(aux_team);


            // executando os jogos
            for (int i = 0; i < 5; i++) { // jogando contra os times da pos 0 até a pos 4 da lista
                String options1[] = {"Próxima partida", "Dados dos jogadores", "Dados do meu time"};
                String options2[] = {"Sim", "Não"};
                opc = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Selecione uma das opções abaixo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);

                switch (opc) {
                    case 0: // Jogar partida
                        // sorteando um valor aleatório entre 0 e 1 (valor 0 -> time ganhou), (valor 1 -> oponente ganhou)
                        Random rand = new Random();
                        int resultado = rand.nextInt(11); // gera de 0 a 11-1 => gera de 0 a 10
                        int rounds = 16 + rand.nextInt(20); // 16 é a quantidade mínima de rounds para uma vitória

                        // de 0->5 o meu time ganhou
                        if (resultado <= 5) { // meu time ganhou
                            time_usuario.addVitory();
                            if (rounds == 16)
                                JOptionPane.showMessageDialog(null, "Que jogo meu amigo! Garantimos a vitória com esse lindo (16x0)!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            else if (rounds >= 32) // overtime
                                JOptionPane.showMessageDialog(null, "No overtime! Garantimos a vitória!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, time_usuario.getTeamName() + "Garantimos a vitória!! Placar (16x" + (rounds - 16) + ")", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            opponents_teams.get(i).addVitory(); // time oponente venceu
                            if (rounds == 16)
                                JOptionPane.showMessageDialog(null, "Nem tudo na vida são flores!\n Ainda mais com essa derrota para a " + opponents_teams.get(i).getTeamName() + " por incríveis (16x0)!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            else if (rounds >= 32) // overtime
                                JOptionPane.showMessageDialog(null, "Essa foi por pouco, no overtime! Mas não garantimos a vitória em cima da " + opponents_teams.get(i).getTeamName(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, time_usuario.getTeamName() + "Infelizmente perdemos por (16x" + (rounds - 16) + ")", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }

                        // calculando dados dos jogadores
                        for (int j = 0; j < 5; j++){ // percorrendo a lista de jogadores e colocando valores aleatórios nos seus atributos
                            int aux;

                            aux = rand.nextInt(35);
                            time_usuario.getPlayers(j).setKills(aux);

                            aux = rand.nextInt(15);
                            time_usuario.getPlayers(j).setAssistances(aux);

                            aux = rand.nextInt(30);
                            time_usuario.getPlayers(j).setDeaths(aux);

                            time_usuario.getPlayers(j).setKd_rating();
                        }

                        // pra verificar se o usuário deseja saber os detalhes dos jogadores do seu time na última partida
                        int aux1 = JOptionPane.showOptionDialog(null, "Deseja ver os detalhes dos jogadores desta partida:", "Selecione uma das opções abaixo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[1]);
                        if (aux1 == 1) // quer ver!
                            JOptionPane.showMessageDialog(null, "Relatório dos jogadores:" + time_usuario.getPlayersInfo(), "Exibindo relatório dos jogadores", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 1: // exibindo dados dos jogadores (mini relatório)
                        JOptionPane.showMessageDialog(null, "Relatório dos jogadores:" + time_usuario.getPlayersInfo(), "Exibindo relatório dos jogadores", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2: // exibindo status do time do usuário
                        JOptionPane.showMessageDialog(null, "Meu time: " + time_usuario.getTeamFullName() + "\nVitórias: " + time_usuario.getTeam_victorys(), "Exibindo relatório do meu time", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            }

            // fim dos jogos, exibindo relatório do time

            /*  Você deve permitir a geração dos seguintes relatórios:
                    a) Funcionários (dividido pelo tipo).
                    b) Salários (dividido pelo tipo).
                    c) Score de gols por jogador.

                -Relatório (PDF):
                    --> O que fizemos (qual foi a ideia)
                    --> Como fizemos
                    --> Como pensamos
                    --> Justificar as escolhas
                    --> Quais conceitos de POO utilizamos (ex, onde eu usei o polimorfismo),
             */

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro! Erro ao cadastrar o seu time, tente novamente", "ERRO!", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
}
