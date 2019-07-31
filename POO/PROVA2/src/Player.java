import java.text.DecimalFormat;

public class Player extends Employee {
    private String nickname; // nickname do jogador
    private int kills; // número de eliminações
    private int deaths; // número de mortes
    private int assistances; // número de assistências
    private double kd_rating; // este valor é calculado
    private String position; // options: Entry Fragger, Suporte, Lurker, Game Leader, AWPer

    public Player(String name, String nickname, int age, String position, double salary){
        super(name, age, salary); // chamando a construtora da superclasse Employee
        this.nickname = nickname;
        this.position = position;
    }

    public String getNickname(){
        return nickname;
    }

    public String getFullInformation() {
        return "Nome: " + getName() + "\nNickname: " + nickname + "\nIdade: " + getAge() + "\nPosição: " + position + "\nKills: " + kills + "\nMortes: " + deaths + "\nAssistências: " + assistances + "K/D: " + kd_rating;
    }

    public double getKd_rating() {
        return kd_rating;
    }

    // taxa de kill/mortes sendo atualizadas
    public void setKd_rating(){
        if (deaths != 0) {
            // https://www.devmedia.com.br/arredondando-numeros-em-java/28248
            double kd = (double) kills / deaths; // salvando o valor em uma variável aux
//            DecimalFormat df = new DecimalFormat("#.00"); // para utilizar apenas duas casas decimais
            // df.format(kd); // df.format(var); retorna uma string formatada
//            kd_rating = Double.parseDouble(df.format(kd));
            this.kd_rating = kd;
        }
        else
            kd_rating = kills; // posso ter um jogador com 0 mortes, ex: 17/0
    }

    public int getKills(){
        return kills;
    }

    public void setKills(int kills){
        if (kills >= 0)
            this.kills = kills;
        else
            this.kills = 0;
    }

    public int getDeaths(){
        return deaths;
    }

    public void setDeaths(int deaths){
        if (deaths >= 0)
            this.deaths = deaths;
        else
            this.deaths = 0;
    }

    public int getAssistances(){
        return assistances;
    }

    public void setAssistances(int assistances){
        if (assistances >= 0)
            this.assistances = assistances;
        else
            this.assistances = 0;
    }

    public String getPosition(){
        return position;
    }
}
