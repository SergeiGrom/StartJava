public class Wolf {
    public String sex;
    public String name;
    public double weight;
    public int age;
    public String color;

    public Wolf(String sex, String name, double weight, int age, String color) {
        this.sex = sex;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    public void move() {
        System.out.println("Идти");;
    }

    public void sit() {
        System.out.println("Сидеть");
    }

    public void run() {
        System.out.println("Бежать");
    }

    public void howl() {
        System.out.println("Выть");
    }

    public void hunt() {
        System.out.println("Охотиться");
    }
}