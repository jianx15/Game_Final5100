package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterDAO {
    private Connection connection;
    private Map<String, Location> locationMap;

    public CharacterDAO(Connection connection, Map<String, Location> locationMap) {
        this.connection = connection;
        this.locationMap = locationMap;
    }

    public void saveCharacter(Character character) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO characters (name, location, originalDamage) VALUES (?, ?, ?)");
        statement.setString(1, character.getName());
        statement.setString(2, character.getLocation().toString());
        statement.setInt(3, character.getOriginalDamage());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public List<Character> getAllCharacters() throws SQLException {
        List<Character> characters = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM characters");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String locationString = resultSet.getString("location");
            Location location = locationMap.get(locationString);
            int originalDamage = resultSet.getInt("originalDamage");
            Character character = new Character(name, location, originalDamage);
            characters.add(character);
        }
        resultSet.close(); // close the ResultSet
        statement.close(); // close the PreparedStatement
        return characters;
    }

    public void deleteCharacter(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM characters WHERE name = ?");
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }
}
