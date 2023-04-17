package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemsDAO {
    private Connection connection;
    private Map<String, Location> nameLocationMap;
    private Map<String, Weapon> nameWeaponMap;
    private Map<String, Medicine> nameMedicineMap;

    public ItemsDAO(Connection connection, Map<String, Location> nameLocationMap, Map<String, Weapon> nameWeaponMap, Map<String, Medicine> nameMedicineMap) {
        this.connection = connection;
        this.nameMedicineMap = nameMedicineMap;
        this.nameLocationMap = nameLocationMap;
        this.nameWeaponMap = nameWeaponMap;
    }

    public void saveItems(Items items) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO item (weapon, med, location) VALUES (?, ?, ?)");
        statement.setString(1, items.getWeapon().toString());
        statement.setString(2, items.getMedicine().toString());
        statement.setString(3, items.getLocation().toString());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public List<Items> getAllItems() throws SQLException {
        List<Items> itemsList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM item");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String weaponString = resultSet.getString("weapon");
            String medicineString = resultSet.getString("med");
            String locationString = resultSet.getString("location");

            Weapon weapon = nameWeaponMap.get(weaponString);
            Medicine medicine = nameMedicineMap.get(medicineString);
            Location location = nameLocationMap.get(locationString);

            Items items = new Items(weapon, medicine, location);
            itemsList.add(items);
        }
        resultSet.close(); // close the ResultSet
        statement.close(); // close the PreparedStatement
        return itemsList;
    }

    public void deleteItems(String location) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE location = ?");
        statement.setString(1, location);
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }
}
