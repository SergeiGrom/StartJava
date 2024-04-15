public class Jaeger {
    private String modelName;
    private String category;
    private String origin;
    private int pilotsNum;
    private double height;
    private double weight;
    private int armorClass;
    private double dangerRate;

    public Jaeger() {
    }

    public Jaeger(String modelName, String category, String origin, int pilotsNum,
            double height, double weight, int armorClass, double dangerRate) {
        this.modelName = modelName;
        this.category = category;
        this.origin = origin;
        this.pilotsNum = pilotsNum;
        this.height = height;
        this.weight = weight;
        this.armorClass = armorClass;
        this.dangerRate = dangerRate;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPilotsNum() {
        return pilotsNum;
    }

    public void setPilotsNum(int pilotsNum) {
        this.pilotsNum = pilotsNum;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public double getDangerRate() {
        return dangerRate;
    }

    public void setDangerRate(double dangerRate) {
        this.dangerRate = dangerRate;
    }

    public void useMeleeWeapon() {
        System.out.println("Close distance fight mode activated");
    }

    public void useRangeWeapon() {
        System.out.println("Fire mode activated");
    }

    public boolean stealthMode() {
        return true;
    }

    public void move() {
        System.out.println("Drive engines activated");
    }

    public void attack() {
        System.out.println("Destroy target: accepted");
    } 

}