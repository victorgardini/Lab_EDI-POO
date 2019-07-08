import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        List<Team> times = new ArrayList<>(); // lista que armazena os times
        String options1[] = {"Novo time", "Exibir times", "Finalizar campeonato"};
        String positions[] = { "Entry Fragger", "Suporte", "Lurker", "Game Leader", "AWPer"};
        int opc;

        do {
            opc = JOptionPane.showOptionDialog(null, "Qual opção deseja cadastrar?", "Selecione uma das opções", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);

            switch (opc){
                case 0: // Cadastrando um novo time (name, short_name, founded, manager, formplayers)

                    // Entrada de valores (pré novo time)
                    String team_name = JOptionPane.showInputDialog(null, "Nome:", "Nome do novo time", JOptionPane.QUESTION_MESSAGE);
                    String team_short_name = JOptionPane.showInputDialog(null, "Nickname:", "Sigla novo time", JOptionPane.QUESTION_MESSAGE);
                    int team_founded = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano fundação:", "Ano de fundação do novo time", JOptionPane.QUESTION_MESSAGE));
                    int team_victorys = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de vitórias neste campeonato: ", "Vitórias do novo time", JOptionPane.QUESTION_MESSAGE));

                    // Criando o manager
                    String team_manager = JOptionPane.showInputDialog(null, "Nome coach:", "Novo Coach time", JOptionPane.QUESTION_MESSAGE);
                    Manager auxmanager = new Manager(team_manager);

                    // Formando a lista de jogadores (name, nickname, age, kd_rating)
                    JOptionPane.showMessageDialog(null, "Agora vamos cadastrar os 5 jogadores!!");
                    List<Player> team_players = new ArrayList<>();
                    for (int i = 0; i < 5; i++){
                        String nome_jogador = JOptionPane.showInputDialog(null, "Nome: ", "Nome do " + (i+1) + " jogador", JOptionPane.QUESTION_MESSAGE);
                        String nickname_jogador = JOptionPane.showInputDialog(null, "Nickname: ", "Nickname do " + (i+1) + " jogador", JOptionPane.QUESTION_MESSAGE);
                        int age_jogador = Integer.parseInt(JOptionPane.showInputDialog(null, "Idade: ", "Idade do " + (i+1) + " jogador: ", JOptionPane.QUESTION_MESSAGE));
                        int kills_joador = Integer.parseInt(JOptionPane.showInputDialog(null, "Abates : ", "Abates do " + (i+1) + " jogador: ", JOptionPane.QUESTION_MESSAGE));
                        int deaths_jogador = Integer.parseInt(JOptionPane.showInputDialog(null, "Mortes: ", "Mortes do " + (i+1) + " jogador", JOptionPane.QUESTION_MESSAGE));
                        int assistances_jogador = Integer.parseInt(JOptionPane.showInputDialog(null, "Assistências: ", "Assistências do "  + (i+1) + " jogador", JOptionPane.QUESTION_MESSAGE));
                        String position_jogador = (String) JOptionPane.showInputDialog(null, "Posição do jogador: ", "Posição do jogador "  + (i+1) +  " no jogo", JOptionPane.QUESTION_MESSAGE, null, positions, positions[0]);

                        // Criando o jogador
                        Player jogador = new Player(nome_jogador, nickname_jogador, age_jogador, kills_joador, deaths_jogador, assistances_jogador, position_jogador);
                        team_players.add(jogador);
                    }

                    // Instanciando um novo obj time, e salvando na lista
                    Team novo_time = new Team(team_name, team_short_name, team_founded, auxmanager, team_players, team_victorys);
                    times.add(novo_time);
                    break;

                case 1: // Exibindo times cadastrados
                    JOptionPane.showMessageDialog(null, "Exibindo time cadastrados:", "Importante", JOptionPane.INFORMATION_MESSAGE);

                    // foreach de times que exibe o nome do time e os seus jogadores
                    for (Team team: times){
                        JOptionPane.showMessageDialog(null, "Exibindo time:\n" + team.getFullName());
                        team.getPlayers();
                    }

                    break;
                case 2: // encerrando programa & finalizando o campeonato (exibindo relatórios e vencedores)
                    JOptionPane.showMessageDialog(null, "Campeonato finalizado, exibindo o time vencedor e os jogadores de destaque", "Fim do campeonato", JOptionPane.INFORMATION_MESSAGE);

                    // Exibindo, primeiramente, os jogadores em destaque e após isso, o time vencedor

                    // Captando o melhor time do campeonato (mais vitórias) e os melhores jogadores de todos os times
                    // para saber o time vencedor
                    Team time_vencedor = null;
                    int quant_vitorias = -1000;

                    // para saber o que mais abateu
                    Team melhor_kills = null;
                    double aux_melhor_kills = -1000;

                    // para saber a melhor assistencia
                    Team melhor_assistencias = null;
                    double aux_melhor_assist = -1000;

                    // para saber o melhor kd
                    Team melhor_kd = null;
                    double aux_melhor_kd = -1000;

                    // salvando o time dos jogadores que se destacaram, como eu sei o time, fica fácil encontrar o que se destacou
                    for (Team team: times){
                        // estrutura para saber o time vencedor
                        if (team.getTeam_victorys() >= quant_vitorias) {
                            time_vencedor = team;
                            quant_vitorias = team.getTeam_victorys();
                        }

                        // estrutura pra pegar o obj player com maior quantidade de kills
                        if (team.getBestKillsPlayer().getKills() >= aux_melhor_kills) {
                            aux_melhor_kills = team.getBestKillsPlayer().getKills();
                            melhor_kills = team;
                        }

                        // estrutura pra pegar o obj player com maior quantidade de assistências
                        if (team.getBestAssistancePlayer().getAssistances() >= aux_melhor_assist) {
                            aux_melhor_assist = team.getBestAssistancePlayer().getAssistances();
                            melhor_assistencias = team;
                        }

                        // estrutura pra pegar o obj player com maior quantidade de k/d
                        if (team.getBestKDPlayer().getKd_rating() >= aux_melhor_kd) {
                            aux_melhor_kills = team.getBestKDPlayer().getKd_rating();
                            melhor_kills = team;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "O time vencedor é: " + time_vencedor.getFullName() + "com " + time_vencedor.getTeam_victorys());
                    JOptionPane.showMessageDialog(null, "Exibindo a lista de jogadores em destaque:" +
                            "\nJogador que mais eliminou: " + melhor_kills.getBestKillsPlayer().getFullInformation() + "\nEliminações: " + melhor_kills.getBestKillsPlayer().getKills() +
                            "\n\nJogador com o melhor K/D: " + melhor_kd.getBestKDPlayer().getFullInformation() + "\nK/D: " + melhor_kd.getBestKDPlayer().getKd_rating() +
                            "\n\nJogador com mais assistências: " + melhor_assistencias.getBestAssistancePlayer().getFullInformation()  + "\nAssistências: " + melhor_assistencias.getBestAssistancePlayer().getAssistances(),
                            "Jogadores que se destacaram", JOptionPane.INFORMATION_MESSAGE);


                    JOptionPane.showMessageDialog(null, "Até mais!!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
            }
        } while(opc != 2);
    }
}
