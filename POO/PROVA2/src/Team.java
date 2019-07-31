import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Team {
    private String name; // nome do time
    private String short_name; // sigla do time
    private int founded; // ano de fundação
    private Employee manager; // obj funcionário (Coach)
    private List<Player> formplayers; // lista de jogadores
    private int team_victorys; // quantidade de vitórias

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
        return "Nome: " + name + " [" + short_name + "]\nCoach:\n" + manager.getFullInformation();
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

    // exibe na tela uma caixa contendo o nome, idade e nickname de cada jogador do time
    public void getTeamPlayersListInfo() {
        for (Player formplayer: formplayers) { // procurando na lista de jogadores cada obj jogador
            JOptionPane.showMessageDialog(null, "Nome: " + formplayer.getName() +
                    "\nNickname: " + formplayer.getNickname() +
                    "\nIdade: " + formplayer.getAge() +
                    "\nPosição: " + formplayer.getPosition(), "Exibindo integrantes do time", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // retorna o respedtivo obj jogador do time (quando utilizado em um for)
    public Player getPlayers(int i){
        return formplayers.get(i);
    }


    // Retorna uma String concatenada com os principais dados de cada Player (relatório geral)
    public String getPlayersInfo(){
        String aux = "";
        for (Player player: formplayers) {
            aux += "\n------------------------------------\nNome: " + player.getName() + "\nApelido: " + player.getNickname() + "\nPosição: " + player.getPosition() + "\nEliminações: " + player.getKills() + "\nMortes: " + player.getDeaths() + "\nAssistências: " + player.getAssistances() + "\nK/D: " + player.getKd_rating();
        }
        return aux;
    }

    // Retorna uma String concatenada com os salários de cada Player (relatório salário)
    public String getTeamPlayersSalary(){
        String aux = "";
        for (Player player: formplayers)
            aux += "\n------------------------------------\nNome: " + player.getName() + "\nApelido: " + player.getNickname() + "\nPosição: " + player.getPosition() + "\nSalário: R$ " + player.getSalary();
        return aux;
    }

    // Funções abaixo retornam uma String contendo os melhores jogadores em 3 critérios (k/d, kills e assistências)

    // Retorna um obj jogador com maior kd
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

    // Retorna um obj jogador com maior quantidade de kills
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

    // Retorna um obj jogador com maior quantidade de assistencias
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

    public Employee getManager() {
        return manager;
    }

    public void bonus(){
        // aplicando bonus no treinador
        manager.setSalary(manager.getSalary(), 0.2);
        for (Player player: formplayers){
            player.setSalary(player.getSalary(), 0.4);
        }
    }
}
