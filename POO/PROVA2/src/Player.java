public class Player {
    private String name;
    private String nickname;
    private int age;
    private int kills; // número de eliminações
    private int deaths; // número de mortes
    private int assistances; // número de assistências
    private double kd_rating; // este valor é calculado
    private String position; // options: Entry Fragger, Suporte, Lurker, Game Leader, AWPer

    public Player(String name, String nickname, int age, int kills, int deaths, int assistances, String position){
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.kills = kills;
        this.deaths = deaths;
        this.assistances = assistances;
        this.kd_rating = (double) kills / deaths;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public String getNickname(){
        return nickname;
    }

    public String getFullInformation() {
        return "Nome: " + name + "\nNickname: " + nickname + "\nIdade: " + age + "\nPosição: " + position;
    }

    public int getAge(){
        return age;
    }

    public double getKd_rating(){
        return kd_rating;
    }

    public int getKills(){
        return kills;
    }

    public int getDeaths(){
        return deaths;
    }

    public int getAssistances(){
        return assistances;
    }

    public String getPosition(){
        return position;
    }
}
