import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Team {
    private String name;
    private String short_name;
    private int founded;
    private Manager manager;
    private List<Player> formplayers;
    private int team_victorys;

    public Team(String name, String short_name, int founded, Manager manager, List<Player> formplayers){
        this.name = name;
        this.short_name = short_name; // sigla
        this.founded = founded;
        this.manager = manager;
        this.formplayers = formplayers; // já recebe a lista de jogadores por parâmetro
        this.team_victorys = 0;
    }

    public String getTeamName() {
        return name;
    }

    public String getTeamShortName() {
        return short_name;
    }

    public String getTeamFullName() {
        return "Nome: " + name + " [" + short_name + "]\nCoach: " + manager.getManagerName();
    }

    public int getTeamFounded() {
        return founded;
    }

    public String getManagerName() {
        return manager.getManagerName();
    }

    public int getTeam_victorys() {
        return team_victorys;
    }

    public void getTeamPlayersInfo() {
        // Foreach
        for (Player formplayer: formplayers) {
            JOptionPane.showMessageDialog(null, formplayer.getFullInformation, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // exibe na tela uma caixa contendo o nome, idade e nickname de cada jogador do time
    public void getTeamPlayersListInfo() {
        for (Player formplayer: formplayers) { // procurando na lista de jogadores cada obj jogador
            JOptionPane.showMessageDialog(null, "Nome: " + formplayer.getName() +
                    "\nNickname: " + formplayer.getNickname() +
                    "\nIdade: " + formplayer.getAge() +
                    "\nPosição: " + aux.getPosition(), "Exibindo integrantes do time", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Funções abaixo retornam uma String contendo os melhores jogadores em 3 critérios (k/d, kills e assistências)
    public Player getTeamBestKDPlayer() {
        double maior = -1000000;
        Player aux = null;
        for (Player bestplayer: formplayers){
            if (bestplayer.getKd_rating() >= maior){
                maior = bestplayer.getKd_rating();
                aux = bestplayer;
            }
        }

        // Já tenho o obj melhor jogador
        return aux;
//        return ("Melhor jogador:" +
//                "\nNome: " + aux.getName() +
//                "\nNickname: " + aux.getNickname() +
//                "\nPosição: " + aux.getNickname() +
//                "\nK/D: " + aux.getKd_rating());
    }

    public Player getTeamBestKillsPlayer() {
        double maior = -1000000;
        Player aux = null;
        for (Player bestplayer: formplayers){
            if (bestplayer.getKills() >= maior){
                maior = bestplayer.getKills();
                aux = bestplayer;
            }
        }

        // Já tenho o obj melhor jogador
        return aux;
    }

    public Player getTeamBestAssistancePlayer() {
        double maior = -1000000;
        Player aux = null;
        for (Player bestplayer: formplayers){
            if (bestplayer.getAssistances() >= maior){
                maior = bestplayer.getAssistances();
                aux = bestplayer;
            }
        }

        // Já tenho o obj melhor jogador
        return aux;
    }
}
