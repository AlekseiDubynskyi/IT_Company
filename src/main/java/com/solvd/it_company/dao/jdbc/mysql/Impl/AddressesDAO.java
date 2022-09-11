package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IAddressesDAO;
import com.solvd.it_company.models.Addresses;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AddressesDAO implements IAddressesDAO {
    List<Addresses> addresses = new LinkedList<>();

    @Override
    public Addresses getAddressById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Addresses WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getAddressById(resultSet));
                return getAddressById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Addresses getAddressById(ResultSet resultSet) throws SQLException {
        Addresses newAddress = new Addresses();
        newAddress.setId(resultSet.getInt("id"));
        newAddress.setAddress(resultSet.getString("address"));
        newAddress.setDistrict(resultSet.getString("district"));
        newAddress.setPostal_code(resultSet.getString("postal_code"));
        newAddress.setCity_id(resultSet.getInt("city_id"));
        return newAddress;
    }

    @Override
    public List<Addresses> getAllAddresses() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Addresses");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                addresses.add(getAddressById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public void addAddress(int id, String address, String district, String postal_code, int city_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Addresses VALUE(default, ?, ?, ?, ?)");
            preparedStatement.setString(1, address);
            preparedStatement.setString(2, district);
            preparedStatement.setString(3, postal_code);
            preparedStatement.setInt(4, city_id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateAddress(Addresses addresses) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Addresses SET address=?, district=?, " +
                    "postal_code=?, city_id=? WHERE id=?");
            preparedStatement.setString(1, addresses.getAddress());
            preparedStatement.setString(2, addresses.getDistrict());
            preparedStatement.setString(3, addresses.getPostal_code());
            preparedStatement.setInt(4, addresses.getCity_id());
            preparedStatement.setInt(5, addresses.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + addresses.getId() + "-" + addresses.getAddress());
            } else
                System.out.println("Update process was failed: " + addresses.getId() + "-" + addresses.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAddress(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Addresses WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
