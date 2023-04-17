import dao.*;
import dao.Character;
import scene.SceneIntroGUI;
import scene.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Create connection to MySQL database
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo", "root", "0827");

        Utility utility = new Utility();

        // TODO: can extract to a DataLoader class
        WeaponDAO weaponDAO = new WeaponDAO(conn);
        List<Weapon> weapons = weaponDAO.getAllWeapons();
        Map<String, Weapon> nameWeaponMap = utility.getStringWeaponMapping(weapons);

        MedicineDAO medicineDAO = new MedicineDAO(conn);
        List<Medicine> medicines = medicineDAO.getAllMedicines();
        Map<String, Medicine> nameMedicineMap = utility.getStringMedicineMapping(medicines);

        LocationDAO locationDAO = new LocationDAO(conn);
        List<Location> locations = locationDAO.getAllLocations();
        Map<String, Location> nameLocationMap = utility.getStringLocationMapping(locations);

        CharacterDAO characterDAO = new CharacterDAO(conn, nameLocationMap);
        List<Character> characters = characterDAO.getAllCharacters();
        Map<String, Character> nameCharacterMap = utility.getStringCharacterMapping(characters);

        NPCDAO npcDao = new NPCDAO(conn, nameLocationMap);
        List<NPC> npcs = npcDao.getAllNPCs();

        ItemsDAO itemsDAO = new ItemsDAO(conn, nameLocationMap, nameWeaponMap, nameMedicineMap);
        List<Items> items = itemsDAO.getAllItems();

        // Collect user information
        SceneIntroGUI sceneIntroGUI = new SceneIntroGUI();

        String characterName = sceneIntroGUI.getUsername();

        // Wait until user enters a valid name
        while (sceneIntroGUI.getUsername() == null) {
            try {
                Thread.sleep(100); // wait for 100 milliseconds before checking again
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Character player = new Character(sceneIntroGUI.getUsername(), null, 55);
        for (Medicine medicine : medicines) {
            player.getInventory().addMedicine(medicine);
        }

        // Game starts
        GameEngine gameEngine = new GameEngine(player, utility);
        gameEngine.start();

        // close the connection
        conn.close();
    }
}
