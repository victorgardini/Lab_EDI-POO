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

    public Team(String name, String short_name, int founded, Manager manager, List<Player> formplayers, int team_victorys){
        this.name = name;
        this.short_name = short_name;
        this.founded = founded;
        this.manager = manager;
        this.formplayers = formplayers; // já recebe a lista por parâmetro
        this.team_victorys = team_victorys;
    }

    public String getName(){
        return name;
    }

    public String getShortName(){
        return short_name;
    }

    public String getFullName(){
        return "Nome: " + name + " [" + short_name + "]\nCoach: " + manager.getManagerName();
    }

    public int getFounded(){
        return founded;
    }

    public String getManagerName(){
        return manager.getManagerName();
    }

    public int getTeam_victorys(){
        return team_victorys;
    }

    public void getPlayers(){
        // Foreach
        for (Player formplayer : formplayers) {
            JOptionPane.showMessageDialog(null, "Nome: " + formplayer.getName() +
                    "\nApelido: " + formplayer.getNickname() +
                    "\nIdade: " + formplayer.getAge() +
                    "\nPosição: " + formplayer.getPosition() +
                    "\nAbates: " + formplayer.getKills() +
                    "\nMortes: " + formplayer.getDeaths() +
                    "\nAssistências: " + formplayer.getAssistances() +
                    "\nK/D Ratio: " + formplayer.getKd_rating(), "Jogador, Time: " + getName() + "[" + getShortName() + "]", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Funções abaixo retornam uma String contendo os melhores jogadores em 3 critérios (k/d, kills e assistências)
    public Player getBestKDPlayer(){
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

    public Player getBestKillsPlayer(){
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

    public Player getBestAssistancePlayer(){
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
