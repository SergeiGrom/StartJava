public class WolfTest {
    public static void main(String[] args) {
        Wolf whiteWolf = new Wolf("Male", "Beast", 20.5, 6, "White");
        System.out.println("Sex: " + whiteWolf.sex);
        System.out.println("Name: " + whiteWolf.name);
        System.out.println("Weight: " + whiteWolf.weight);
        System.out.println("Age: " + whiteWolf.age);
        System.out.println("Color: " + whiteWolf.color);
        whiteWolf.move();
        whiteWolf.sit();
        whiteWolf.run();
        whiteWolf.howl();
        whiteWolf.hunt();
    }
}