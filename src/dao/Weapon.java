package dao;

public class Weapon {
    private String name;
    private int attackDamage;

    public Weapon(String name, int attackDamage) {
        this.name = name;
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return attackDamage;
    }

    public String describe() {
        return this.name + "'s damage is " + getDamage() + ". What a great weapon!";
    }

}
