public class WolfTest {
    public static void main(String[] args) {
        Wolf whiteWolf = new Wolf("He-wolf", "Beast", 20.5, 6, "White");
        System.out.println("Child Sex: " + whiteWolf.getSex());
        whiteWolf.setSex("She-wolf");
        System.out.println("New Sex: " + whiteWolf.getSex());
        System.out.println("Name: " + whiteWolf.getName());
        System.out.println("Weight: " + whiteWolf.getWeight());
        System.out.println("Age: " + whiteWolf.getAge());
        whiteWolf.setAge(9);
        whiteWolf.setAge(1);
        System.out.println("New Age: " + whiteWolf.getAge());
        System.out.println("Color: " + whiteWolf.getColor());
        System.out.println("\nWhiteWolf can: ");
        whiteWolf.move();
        whiteWolf.sit();
        whiteWolf.run();
        whiteWolf.howl();
        whiteWolf.hunt();
    }
}