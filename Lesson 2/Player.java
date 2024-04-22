public class Player {
    private String name;
    private int playerNum;

    public Player(String name, int playerNum) {
        this.name = name;
        this.playerNum = playerNum;
    }

    public String getName() {
        return name;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
}