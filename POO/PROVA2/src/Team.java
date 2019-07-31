import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Team {
    private String name;
    private String short_name;
    private int founded;
    private Employee manager; // funcionário Coach
    private List<Player> formplayers;
    private int team_victorys;

    public Team(String name, String short_name, int founded, Employee manager, List<Player> formplayers){
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
        return "Nome: " + name + " [" + short_name + "]\nCoach: " + manager.getName();
    }

    public int getTeamFounded() {
        return founded;
    }

    public String getManagerName() {
        return manager.getName();
    }

    public int getTeam_victorys() {
        return team_victorys;
    }

    public void addVitory(){
        team_victorys += 1; // somar mais uma vitória no time
    }

    public void getTeamPlayersInfo() {
        // Foreach
        for (Player formplayer: formplayers) {
            JOptionPane.showMessageDialog(null, "Informação jogador:\n" + formplayer.getFullInformation(), "Obtendo dados do jogador:" + formplayer.getName() , JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // exibe na tela uma caixa contendo o nome, idade e nickname de cada jogador do time
    public void getTeamPlayersListInfo() {
        for (Player formplayer: formplayers) { // procurando na lista de jogadores cada obj jogador
            JOptionPane.showMessageDialog(null, "Nome: " + formplayer.getName() +
                    "\nNickname: " + formplayer.getNickname() +
                    "\nIdade: " + formplayer.getAge() +
                    "\nPosição: " + formplayer.getPosition(), "Exibindo integrantes do time", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // retorna um por um de cada jogador do time
    public Player getPlayers(int i){
        return formplayers.get(i);
    }

    public String getPlayersInfo(){
        String aux = "";
        for (Player player: formplayers) {
            aux += "\n------------------------------------\nNome: " + player.getName() + "\nApelido: " + player.getNickname() + "\nPosição: " + player.getPosition() + "\nEliminações: " + player.getKills() + "\nMortes: " + player.getDeaths() + "\nAssistências: " + player.getAssistances() + "\nK/D: " + player.getKd_rating();
        }
        return aux;
    }

    public String getTeamPlayersSalary(){
        String aux = "";
        for (Player player: formplayers)
            aux += "\n------------------------------------\nNome: " + player.getName() + "\nApelido: " + player.getNickname() + "\nPosição: " + player.getPosition() + "\nSalário: R$ " + player.getSalary();
        return aux;
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
        // tenho o obj melhor jogador, retornando
        return aux;
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

        // tenho o obj melhor jogador, retornando
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

        // tenho o obj melhor jogador, retornando
        return aux;
    }
}
