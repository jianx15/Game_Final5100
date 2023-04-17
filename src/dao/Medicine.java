package dao;

public class Medicine {
    private String name;
    private int healAmount;

    public Medicine(String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }

    public void consume(Character character) {
        character.healthChange(healAmount);
    }

    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public String describe() {
        return this.name + " is able to heal " + this.healAmount + ". What a great med!";
    }
}
