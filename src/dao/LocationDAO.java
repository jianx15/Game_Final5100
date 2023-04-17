package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {
    private Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveLocation(Location location) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO location (name, description) VALUES (?, ?)");
        statement.setString(1, location.getName());
        statement.setString(2, location.getDescription());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public List<Location> getAllLocations() throws SQLException {
        List<Location> locations = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM location");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            Location location = new Location(name, description);
            locations.add(location);
        }
        resultSet.close(); // close the ResultSet
        statement.close(); // close the PreparedStatement
        return locations;
    }

    public void updateLocation(Location location) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE location SET description = ? WHERE name = ?");
        statement.setString(1, location.getDescription());
        statement.setString(2, location.getName());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public void deleteLocation(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM location WHERE name = ?");
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }
}

