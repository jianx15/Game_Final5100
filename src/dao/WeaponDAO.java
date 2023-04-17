package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeaponDAO {
    private Connection connection;

    public WeaponDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveWeapon(Weapon weapon) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO weapon (name, attackDamage) VALUES (?, ?)");
        statement.setString(1, weapon.getName());
        statement.setInt(2, weapon.getDamage());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public List<Weapon> getAllWeapons() throws SQLException {
        List<Weapon> weapons = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM weapon");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int attackDamage = resultSet.getInt("attackDamage");
            Weapon weapon = new Weapon(name, attackDamage);
            weapons.add(weapon);
        }
        resultSet.close(); // close the ResultSet
        statement.close(); // close the PreparedStatement
        return weapons;
    }

    public void updateWeapon(Weapon weapon) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE weapon SET attackDamage = ? WHERE name = ?");
        statement.setInt(1, weapon.getDamage());
        statement.setString(2, weapon.getName());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public void deleteWeapon(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM weapon WHERE name = ?");
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }
}
