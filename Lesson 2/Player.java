public class Player {
    public String name;
    public int index;

    public Player(int index) {
        name = "";
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }
}