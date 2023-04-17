package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
    private Connection connection;

    public MedicineDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Medicine medicine) throws SQLException {
        String query = "INSERT INTO medicine (name, healAmount) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, medicine.getName());
        statement.setInt(2, medicine.getHealAmount());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public Medicine getByName(String name) throws SQLException {
        String query = "SELECT * FROM medicine WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String medicineName = resultSet.getString("name");
            int healAmount = resultSet.getInt("Amount");
            resultSet.close(); // close the ResultSet
            statement.close(); // close the PreparedStatement
            return new Medicine(medicineName, healAmount);
        } else {
            resultSet.close(); // close the ResultSet
            statement.close(); // close the PreparedStatement
            return null;
        }}

    public List<Medicine> getAllMedicines() throws SQLException {
        List<Medicine> medicines = new ArrayList<>();
        String query = "SELECT * FROM medicine";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String medicineName = resultSet.getString("name");
            int healAmount = resultSet.getInt("healAmount");
            Medicine medicine = new Medicine(medicineName, healAmount);
            medicines.add(medicine);
        }

        resultSet.close(); // close the ResultSet
        statement.close(); // close the PreparedStatement
        return medicines;
    }

    public void update(Medicine medicine) throws SQLException {
        String query = "UPDATE medicine SET healAmount = ? WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, medicine.getHealAmount());
        statement.setString(2, medicine.getName());
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }

    public void delete(String name) throws SQLException {
        String query = "DELETE FROM medicine WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close(); // close the PreparedStatement
    }
}