package dao;

public class Items {
    Weapon weapon;
    Medicine medicine;

    Location location;

    public Items(Weapon weapon, Medicine medicine, Location location) {
        this.weapon = weapon;
        this.medicine = medicine;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
