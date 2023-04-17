package scene;

import dao.Character;
import dao.Location;
import dao.Medicine;
import dao.Weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Utility {
    private Map<String, Location> nameLocationMap;
    private Map<String, Weapon> nameWeaponMap;
    private Map<String, Medicine> nameMedicineMap;
    private Map<String, Character> nameCharacterMap;

    public Map<String, Character> getStringCharacterMapping(List<Character> characterList) {
        Map<String, Character> nameCharacterMap = new HashMap<>();

        for (Character character : characterList) {
            nameCharacterMap.put(character.getName(), character);
        }

        this.nameCharacterMap = nameCharacterMap;
        return nameCharacterMap;
    }

    public Map<String, Location> getStringLocationMapping(List<Location> locationList) {
        Map<String, Location> nameLocationMap = new HashMap<>();

        for (Location location : locationList) {
            nameLocationMap.put(location.getName(), location);
        }

        this.nameLocationMap = nameLocationMap;
        return nameLocationMap;
    }

    public Map<String, Weapon> getStringWeaponMapping(List<Weapon> weaponsList) {
        Map<String, Weapon> nameWeaponMap = new HashMap<>();

        for (Weapon weapon : weaponsList) {
            nameWeaponMap.put(weapon.getName(), weapon);
        }

        this.nameWeaponMap = nameWeaponMap;
        return nameWeaponMap;
    }

    public Map<String, Medicine> getStringMedicineMapping(List<Medicine> medicinesList) {
        Map<String, Medicine> nameMedicineMap = new HashMap<>();

        for (Medicine medicine : medicinesList) {
            nameMedicineMap.put(medicine.getName(), medicine);
        }

        this.nameMedicineMap = nameMedicineMap;
        return nameMedicineMap;
    }

    public String getValidInput(String question, List<String> expectedValues) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        if (expectedValues == null) {
            return ans;
        }
        else {
            while (!expectedValues.contains(ans)) {
                System.out.println("Please give me a valid value!!");
                System.out.println(question);
                ans = scanner.nextLine();
            }
        }

        return ans;
    }

    public Weapon findWeapon(String name) {
        return this.nameWeaponMap.get(name);
    }

    public Character findCharacter(String name) {
        return this.nameCharacterMap.get(name);
    }
}
