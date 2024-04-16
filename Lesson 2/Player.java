public class Player {
    String name;
    Int index;

    public Player(String name, int index) {
        this.name = "";
        this.index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // System.out.print("Введите имя игрока : ");
        this name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        // System.out.print("Введите имя игрока : ");
        this index = index;
    }
}