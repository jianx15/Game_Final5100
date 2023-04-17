package dao;

public class Character {
    private String name;
    private Location location;
    private Inventory inventory;
    private int health;
    private int level;
    private int originalDamage;
    private int damage;

    public Character(String name, Location location, int originalDamage) {
        this.name = name;
        this.location = location;
        this.inventory = new Inventory();
        this.health = 300;
        this.level = 5;
        this.originalDamage = originalDamage;
        this.damage = originalDamage;
    }

    public void addMedicine(Medicine medicine) {
        this.inventory.getMedicines().add(medicine);
    }

    public void addWeapon(Weapon weapon) {
        this.inventory.getWeapons().add(weapon);
    }

    public void wear(Weapon weapon) {
        if (inventory.getWeapons().contains(weapon)); { // check if the character has the weapon in their inventory
            int attackDamage = weapon.getDamage(); // get the attack damage of the weapon
            this.damage = originalDamage + attackDamage; // increase the damage of the character
            inventory.wear(weapon); // equip the weapon
        }
    }

    public void takeOff() {
        int weaponDamage = inventory.getMainWeapon().getDamage(); // get current weapon's damage
        inventory.takeOff(inventory.getMainWeapon()); //take off the current weapon
        this.damage -= weaponDamage; // new damage equals damage minus weapon damage
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOriginalDamage() {
        return originalDamage;
    }

    public void setOriginalDamage(int originalDamage) {
        this.originalDamage = originalDamage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void healthChange(int amount) {
        health += amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void attack(Character target) {
        target.healthChange(-this.damage); // decrease target's health by the damage amount
    }

    public void transfer(Location newLocation) {
        location = newLocation;
    }


}
