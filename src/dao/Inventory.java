package dao;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Medicine> medicines;
    private List<Weapon> weapons;
    private Weapon mainWeapon;

    public Inventory() {
        this.medicines = new ArrayList<>();
        this.weapons = new ArrayList<>();
        this.mainWeapon = null;
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void wear(Weapon weapon) {
        if (weapons.contains(weapon)) {
            mainWeapon = weapon;
        }
    }

    public void takeOff(Weapon weapon) {
        if (mainWeapon == weapon) {
            mainWeapon = null;
        }
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon getMainWeapon() {
        return mainWeapon;
    }

    public void setMainWeapon(Weapon mainWeapon) {
        this.mainWeapon = mainWeapon;
    }
}