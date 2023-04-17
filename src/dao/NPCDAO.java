package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NPCDAO {
    private Connection connection;
    private Map<String, Location> nameLocationMap;

    public NPCDAO(Connection connection, Map<String, Location> nameLocationMap) {
        this.connection = connection;
        this.nameLocationMap = nameLocationMap;
    }

    public void saveNPC(NPC npc) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO npc (name, location) VALUES (?, ?)");
        statement.setString(1, npc.getName());
        statement.setString(2, npc.getLocation().getName());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public List<NPC> getAllNPCs() throws SQLException {
        List<NPC> npcs = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM npc");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String locationName = resultSet.getString("location");
            Location location = nameLocationMap.get(locationName);
            NPC npc = new NPC(name, location);
            npcs.add(npc);
        }
        resultSet.close(); // close the ResultSet
        statement.close(); // close the PreparedStatement
        return npcs;
    }

    public void updateNPC(NPC npc) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE npc SET location = ? WHERE name = ?");
        statement.setString(1, npc.getLocation().getName());
        statement.setString(2, npc.getName());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public void deleteNPC(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM npc WHERE name = ?");
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }
}

