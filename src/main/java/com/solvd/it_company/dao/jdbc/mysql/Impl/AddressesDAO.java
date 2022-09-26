package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IAddressesDAO;
import com.solvd.it_company.models.Addresses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AddressesDAO implements IAddressesDAO {
    private static final Logger LOGGER = LogManager.getLogger(AddressesDAO.class);

    @Override
    public Addresses getAddressById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Addresses WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getAddressById(resultSet));
                return getAddressById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(statement);
            ConnectionUtil.close(connection);
        }
        return null;
    }

    private Addresses getAddressById(ResultSet resultSet) throws SQLException {
        Addresses newAddress = new Addresses();
        newAddress.setId(resultSet.getInt("id"));
        newAddress.setAddress(resultSet.getString("address"));
        newAddress.setDistrict(resultSet.getString("district"));
        newAddress.setPostalCode(resultSet.getString("postal_code"));
        newAddress.setCityId(resultSet.getInt("city_id"));
        return newAddress;
    }

    @Override
    public List<Addresses> getAllAddresses() {
        List<Addresses> addresses = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Addresses");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                addresses.add(getAddressById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return addresses;
    }

    @Override
    public void addAddress(Addresses addresses) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Addresses VALUES(default, ?, ?, ?, ?)");
            preparedStatement.setString(1, addresses.getAddress());
            preparedStatement.setString(2, addresses.getDistrict());
            preparedStatement.setString(3, addresses.getPostalCode());
            preparedStatement.setInt(4, addresses.getCityId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Insertion is successful.");
            } else
                LOGGER.info("Insertion was failed.");
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void updateAddress(Addresses addresses) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Addresses SET address=?, district=?, " +
                    "postal_code=?, city_id=? WHERE id=?");
            preparedStatement.setString(1, addresses.getAddress());
            preparedStatement.setString(2, addresses.getDistrict());
            preparedStatement.setString(3, addresses.getPostalCode());
            preparedStatement.setInt(4, addresses.getCityId());
            preparedStatement.setInt(5, addresses.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + addresses.getId() + " - " + addresses.getAddress());
            } else
                LOGGER.info("Update process was failed: " + addresses.getId() + " - " + addresses.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteAddress(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Addresses WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Delete process is successful.");
            } else
                LOGGER.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }
}
